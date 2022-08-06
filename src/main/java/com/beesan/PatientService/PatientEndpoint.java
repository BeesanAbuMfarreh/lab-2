package com.beesan.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.guides.gs_producing_web_service.GetPatientRequest;
import io.spring.guides.gs_producing_web_service.GetPatientyResponse;
import io.spring.guides.gs_producing_web_service.GetPaymentTypeRequest;
import io.spring.guides.gs_producing_web_service.GetPaymentTypeResponse;

@Endpoint
public class PatientEndpoint {
private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

private PatientRepository PatientRepository;

@Autowired
public PatientEndpoint(PatientRepository PatientRepository) {
this.PatientRepository = PatientRepository;
}

@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPatientRequest")
@ResponsePayload
public GetPatientyResponse getPatient(@RequestPayload GetPatientRequest request) {
GetPatientyResponse response = new GetPatientyResponse();

response.setPatientInfo(PatientRepository.findPatient(request.getName()));

return response;
}


}