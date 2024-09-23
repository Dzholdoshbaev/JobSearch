<#import "../layout.ftlh" as main>

<@main.layout ; spring>


    <h2><@spring.message "resumes.editResume.edit_resume"/></h2>
    <form action="/resumes/edit/${resumeId}" method="post">

        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf-param-name'}"
                   value="${(_csrf.token)!'csrf-token'}"/>
        </#if>

        <h3><@spring.message "resumes.createResume.resume_details"/></h3>
        <div id="resumesContainer">
            <div class="resume-entry mb-3">
                <div class="input-group mb-3">
                    <span class="input-group-text"
                          id="resumeName"><@spring.message "resumes.createResume.resume_name"/></span>
                    <input type="text" class="form-control" aria-label="Resume Name" aria-describedby="name"
                           name="resumes.name" required>
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text"
                          id="categoryId"><@spring.message "resumes.createResume.category_id"/></span>
                    <select class="form-select" aria-label="Category ID" aria-describedby="categoryId"
                            name="resumes.categories">
                        <option selected><@spring.message "resumes.createResume.open_this_select_menu"/></option>
                        <#list categoriesDto as item>
                            <option value="${item.id}">${item.name}</option>
                        </#list>
                    </select>
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text" id="salary"><@spring.message "resumes.createResume.salary"/></span>
                    <input type="number" step="0.01" class="form-control" aria-label="Salary" aria-describedby="salary"
                           name="resumes.salary">
                </div>
                <div class="form-check mb-3">
                    <input class="form-check-input" type="checkbox" id="isActive" name="resumes.isActive">
                    <label class="form-check-label" for="isActive">
                        <@spring.message "resumes.createResume.active"/>
                    </label>
                </div>
            </div>
        </div>

        <h3><@spring.message "resumes.createResume.work_experience"/></h3>
        <button type="button" class="btn btn-primary mt-2" id="workExperienceAddButton">
            + <@spring.message "resumes.createResume.add_work_experience"/>
        </button>
        <div id="addWorkExperience"></div>

        <h3><@spring.message "resumes.createResume.education"/></h3>
        <button type="button" class="btn btn-primary mt-2" id="educationAddButton">
            + <@spring.message "resumes.createResume.add_education"/>
        </button>
        <div id="addEducation"></div>

        <h3><@spring.message "resumes.createResume.contacts"/></h3>
        <div id="contactsContainer">
            <#list contactTypes as type>
                <div class="contact-entry mb-3">
                    <div class="input-group mb-3">
                        <span class="input-group-text">${type.type}</span>
                        <input type="text" class="form-control" aria-label="${type.type}"
                               name="contactsInfoList[${type.id - 1}].info">
                        <input type="hidden" name="contactsInfoList[${type.id - 1}].contactTypes.id" value="${type.id}">
                    </div>
                </div>
            </#list>
        </div>

        <button type="submit" class="btn btn-primary mt-3"><@spring.message "resumes.editResume.edit_resume"/></button>

    </form>

    <style>
        .border {
            border: 1px solid #ddd;
            padding: 15px;
            border-radius: 5px;
        }
    </style>

    <script>
        let showExperienceButton = document.getElementById('workExperienceAddButton');
        let experienceFormContainer = document.getElementById('addWorkExperience');

        let showEducationButton = document.getElementById('educationAddButton');
        let educationFormContainer = document.getElementById('addEducation');

        let educationCounter = 0;
        let experienceCounter = 0;

        showEducationButton.addEventListener('click', () => {
            console.log(educationCounter)
            let newEducationForm = document.createElement('div');
            newEducationForm.className = 'border mt-3';
            newEducationForm.innerHTML = `
                <div class="education-entry mb-3">
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="institution"><@spring.message "resumes.createResume.institution"/></span>
                        <input type="text" class="form-control" aria-label="Institution" aria-describedby="institution"
                               name="educationInfo[` + educationCounter + `].institution" required>
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="program"><@spring.message "resumes.createResume.program"/></span>
                        <input type="text" class="form-control" aria-label="Program" aria-describedby="program"
                               name="educationInfo[` + educationCounter + `].program" required>
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="startDate"><@spring.message "resumes.createResume.start_date"/></span>
                        <input type="date" class="form-control" aria-label="Start Date" aria-describedby="startDate"
                               name="educationInfo[` + educationCounter + `].startDate" required>
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="endDate"><@spring.message "resumes.createResume.end_date"/></span>
                        <input type="date" class="form-control" aria-label="End Date" aria-describedby="endDate"
                               name="educationInfo[` + educationCounter + `].endDate" required>
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="degree"><@spring.message "resumes.createResume.degree"/></span>
                        <input type="text" class="form-control" aria-label="Degree" aria-describedby="degree"
                               name="educationInfo[` + educationCounter + `].degree">
                    </div>
                    <button type="button" class="btn btn-danger mt-2 remove-button">X</button>
                </div>
            `;
            educationCounter++;
            educationFormContainer.appendChild(newEducationForm);
            newEducationForm.querySelector('.remove-button').addEventListener('click', () => {
                educationFormContainer.removeChild(newEducationForm);
            });
        });

        showExperienceButton.addEventListener('click', () => {
            console.log(experienceCounter)
            let newExperienceForm = document.createElement('div');
            newExperienceForm.className = 'border mt-3';
            newExperienceForm.innerHTML = `
                <div class="work-experience-entry mb-3">
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="companyName"><@spring.message "resumes.createResume.company_name"/></span>
                        <input type="text" class="form-control" aria-label="Company Name" aria-describedby="companyName"
                               name="workExperienceInfo[` + experienceCounter + `].companyName" required>
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="position"><@spring.message "resumes.createResume.position"/></span>
                        <input type="text" class="form-control" aria-label="Position" aria-describedby="position"
                               name="workExperienceInfo[` + experienceCounter + `].position" required>
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="year"><@spring.message "resumes.createResume.year"/></span>
                        <input type="number" class="form-control" aria-label="Year" aria-describedby="year"
                               name="workExperienceInfo[` + experienceCounter + `].years" required>
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="responsibilities"><@spring.message "resumes.createResume.responsibilities"/></span>
                        <textarea class="form-control" aria-label="Responsibilities" aria-describedby="responsibilities"
                                  name="workExperienceInfo[` + experienceCounter + `].responsibilities"></textarea>
                    </div>
                    <button type="button" class="btn btn-danger mt-2 remove-button">X</button>
                </div>
            `;
            experienceCounter++;
            experienceFormContainer.appendChild(newExperienceForm);
            newExperienceForm.querySelector('.remove-button').addEventListener('click', () => {
                experienceFormContainer.removeChild(newExperienceForm);
            });
        });
    </script>

</@main.layout>