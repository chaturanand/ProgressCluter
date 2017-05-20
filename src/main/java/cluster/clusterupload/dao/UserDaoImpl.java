package cluster.clusterupload.dao;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;

import cluster.clusterupload.model.User;
import cluster.clusterupload.utils.CommonUtils;

@Component
public class UserDaoImpl implements UserDao {
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public void process(List<String> filesPath) throws JAXBException {
		List<User> list = new ArrayList<User>();

		// read data
		for (String filePath : filesPath) {
			if (CommonUtils.getFileExtension(filePath).equals("csv")) {
				// read csv file
				list.addAll(CommonUtils.readCsv(filePath));
			} else if (CommonUtils.getFileExtension(filePath).equals("xml")) {
				// read xml file
				list.addAll(CommonUtils.readXml(filePath));
			}
		}
		// import data
		importData(list);
	}

	public void importData(List<User> list) {
		String sql = "INSERT INTO cluster(id,order_cc,to_cc,amount,created_at) VALUES(:id,:order_cc,to_cc,amount,created_at)";
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(list.toArray());
		namedParameterJdbcTemplate.batchUpdate(sql, batch);
	}

}
