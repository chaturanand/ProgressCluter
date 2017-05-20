package cluster.clusterupload.service;

import java.util.List;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cluster.clusterupload.dao.UserDao;

@Service
public class UserserviceImpl implements UserService {

	@Autowired
	UserDao userDao;

	public void process(List<String> filePath) throws JAXBException {
		userDao.process(filePath);

	}

}
