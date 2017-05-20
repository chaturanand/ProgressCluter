package cluster.clusterupload.model;

import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cluster")
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
	private Integer id;
	private String order_cc;
	private String to_cc;
	private Integer amount;
	private Timestamp createdAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrder_cc() {
		return order_cc;
	}

	public void setOrder_cc(String order_cc) {
		this.order_cc = order_cc;
	}

	public String getTo_cc() {
		return to_cc;
	}

	public void setTo_cc(String to_cc) {
		this.to_cc = to_cc;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

}
