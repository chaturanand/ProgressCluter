package cluster.clusterupload.service;

import java.util.List;

import javax.xml.bind.JAXBException;


public interface UserService {
	public void process(List<String> filePath) throws JAXBException;

}
