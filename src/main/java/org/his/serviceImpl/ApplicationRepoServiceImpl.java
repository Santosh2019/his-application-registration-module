package org.his.serviceImpl;

import org.his.bean.CitizinAppEntity;
import org.his.binding.CitizenApp;
import org.his.repository.CitizinAppRepo;
import org.his.service.ApplicationRegiService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApplicationRepoServiceImpl implements ApplicationRegiService {

	@Autowired
	private CitizinAppRepo citizinAppRepo;

	@Override
	public Integer createApplication(CitizenApp app) {

		String endPointUrl = "https://ssa-web-api.herokuapp.com/ssn/{ssn}";

		RestTemplate rt = new RestTemplate();

		ResponseEntity<String> resEntity = rt.getForEntity(endPointUrl, String.class, app.getSsn());

		String stateName=resEntity.getBody();
		
		if("New Jersey".equals(stateName)) {
			
			CitizinAppEntity entity=new CitizinAppEntity();
			
			BeanUtils.copyProperties(app, entity);
			
			entity.setStateName(stateName);

			CitizinAppEntity save=citizinAppRepo.save(entity);
			
			return save.getAppId();
		}
		return 0;
		
	}

}
