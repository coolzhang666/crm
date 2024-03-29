package cn.edu.cqut.crm.dao;

import cn.edu.cqut.crm.model.Service;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceMapper {

    /**
     * 查询所有新创建服务单据
     * @return 服务单据
     */
    List<Service> selectAll();

    List<Service> selectStatus(String status);
  
    List<Service> selectNewService();
  
    void updateBelong(Service service);
  
    List<Service> getHandleService(int handlerId,String serviceStatus);

    void changeServiceStatus(String ServiceStatus,int serviceId);
  
    void insert(Service service);

    List<Service> getHandService(String serviceStatus);
}
