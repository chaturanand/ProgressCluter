package cluster.clusterupload.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import cluster.clusterupload.model.User;
import cluster.clusterupload.model.Users;

public class CommonUtils {
	public static String getFileExtension(String name) {
		if (name.lastIndexOf(".") != -1 && name.lastIndexOf(".") != 0) {
			return name.substring(name.lastIndexOf(".") + 1);
		} else {
			return "";
		}
	}

	// read CSV FILE FROM PATH
	public static List<User> readCsv(String filePath) {
		List<User> list = new ArrayList<User>();
		BufferedReader buff = null;
		String line = "";
		String splitBy = ",";
		try {
			buff = new BufferedReader(new FileReader(filePath));
			while ((line = buff.readLine()) != null) {
				String[] data = line.split(splitBy);
				User user = new User();
				user.setId(Integer.valueOf(data[0]));
				user.setOrder_cc(data[1]);
				user.setTo_cc(data[2]);
				user.setAmount(Integer.valueOf(data[3]));
				user.setCreatedAt(Timestamp.valueOf(data[4]));
				list.add(user);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (buff != null) {
				try {
					buff.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	// read xml file
	public static List<User> readXml(String filePath) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		Users users = (Users) unmarshaller.unmarshal(new File(filePath));
		return users.getUsers();
	}

}
