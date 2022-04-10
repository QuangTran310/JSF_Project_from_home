// basic date of birth component in update function

						<h:panelGroup id="updateDOB">
							<h:outputLabel class="header">Date of Birth</h:outputLabel>
							<h:inputText class="form-control form-control-sm" id="dob"
								value="#{employeeUIBean.employee.dateOfBirth}"
								a:placeholder="Enter join date."
								converterMessage="Format required: year-month-day.">
								<f:convertDateTime pattern=" yyyy-MM-dd" />
								<f:validator validatorId="emptyDOBValidation" />
								<f:validator validatorId="dobPatternValidation" />
								<p:ajax event="blur"
									listener="#{employeeUIBean.updateEmployeeInfor}"
									update="updateDOB" />
							</h:inputText>
							<h:messages class="error" for="dob" />
						<h:panelGroup/>	
						
// basic date of birth component in update function


// basic join date component in update function

	<h:outputLabel class="header">Join Date</h:outputLabel>
						<h:panelGroup id="updateJD">
							<h:outputLabel class="header">Join date</h:outputLabel>
							<h:inputText class="form-control form-control-sm" id="jd"
								value="#{employeeUIBean.employee.joinDate}"
								a:placeholder="Enter join date."
								converterMessage="Format required: year-month-day.">
								<f:convertDateTime pattern=" yyyy-MM-dd" />
								<f:validator validatorId="emptyJDValidation" />
								<f:validator validatorId="jdPatternValidation" />
								<p:ajax event="blur"
									listener="#{employeeUIBean.updateEmployeeInfor}"
									update="updateJD" />
							</h:inputText>
							<h:messages class="error" for="jd" />
						<h:panelGroup/>	
						
// basic join date component in update function
