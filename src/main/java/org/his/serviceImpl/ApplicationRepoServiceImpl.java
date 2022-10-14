package org.his.serviceImpl;

import org.his.bean.ApplicationRegisteration;
import org.his.binding.CitizinAppRegisBinding;
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
	public Integer createApplication(CitizinAppRegisBinding app) {

		String endPointUrl = "https://ssa.web-api.herokuapp.com/ssn/{ssn}";

		RestTemplate rt = new RestTemplate();

		ResponseEntity<String> resentity = rt.getForEntity(endPointUrl, String.class, app.getSsn());

		String stateName=resentity.getBody();
		
		if("New Jersy".equals(stateName)) {
			
			ApplicationRegisteration appReg=new ApplicationRegisteration();
			
			BeanUtils.copyProperties(app, appReg);
			
			appReg.setStateName(stateName);

			ApplicationRegisteration save=citizinAppRepo.save(appReg);
			
			return save.getAppId();
		}
		return 0;
		
	}

}
