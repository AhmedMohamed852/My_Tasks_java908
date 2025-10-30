package com.hospital.model;

public class Hospital {
	
	Long DOCTOR_ID ;
	String  FIRST_NAME_D;
	String LAST_NAME_D ;
	String SPECIALIZATION ;
	
	Long  PATIENT_ID ;
	String FIRST_NAME_P ;
	String LAST_NAME_P;
	
	String PHONE_P;
	
	String status;

	
	
	public Hospital(Long dOCTOR_ID, String fIRST_NAME_D, String lAST_NAME_D, String sPECIALIZATION, Long pATIENT_ID,
			String fIRST_NAME_P, String lAST_NAME_P, String pHONE_P  , String status) {
		super();
		DOCTOR_ID = dOCTOR_ID;
		FIRST_NAME_D = fIRST_NAME_D;
		LAST_NAME_D = lAST_NAME_D;
		SPECIALIZATION = sPECIALIZATION;
		PATIENT_ID = pATIENT_ID;
		FIRST_NAME_P = fIRST_NAME_P;
		LAST_NAME_P = lAST_NAME_P;
		PHONE_P = pHONE_P;
		status = status;
	}
	
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	public Hospital(Long pATIENT_ID, String fIRST_NAME_P, String lAST_NAME_P, String pHONE_P) {
		super();
		PATIENT_ID = pATIENT_ID;
		FIRST_NAME_P = fIRST_NAME_P;
		LAST_NAME_P = lAST_NAME_P;
		PHONE_P = pHONE_P;
	}



	public Hospital() {
	
	}

	public Long getDOCTOR_ID() {
		return DOCTOR_ID;
	}

	public void setDOCTOR_ID(Long dOCTOR_ID) {
		DOCTOR_ID = dOCTOR_ID;
	}

	public String getFIRST_NAME_D() {
		return FIRST_NAME_D;
	}

	public void setFIRST_NAME_D(String fIRST_NAME_D) {
		FIRST_NAME_D = fIRST_NAME_D;
	}

	public String getLAST_NAME_D() {
		return LAST_NAME_D;
	}

	public void setLAST_NAME_D(String lAST_NAME_D) {
		LAST_NAME_D = lAST_NAME_D;
	}

	public String getSPECIALIZATION() {
		return SPECIALIZATION;
	}

	public void setSPECIALIZATION(String sPECIALIZATION) {
		SPECIALIZATION = sPECIALIZATION;
	}

	public Long getPATIENT_ID() {
		return PATIENT_ID;
	}

	public void setPATIENT_ID(Long pATIENT_ID) {
		PATIENT_ID = pATIENT_ID;
	}

	public String getFIRST_NAME_P() {
		return FIRST_NAME_P;
	}

	public void setFIRST_NAME_P(String fIRST_NAME_P) {
		FIRST_NAME_P = fIRST_NAME_P;
	}

	public String getLAST_NAME_P() {
		return LAST_NAME_P;
	}

	public void setLAST_NAME_P(String lAST_NAME_P) {
		LAST_NAME_P = lAST_NAME_P;
	}

	public String getPHONE_P() {
		return PHONE_P;
	}

	public void setPHONE_P(String pHONE_P) {
		PHONE_P = pHONE_P;
	}
	
	

}
