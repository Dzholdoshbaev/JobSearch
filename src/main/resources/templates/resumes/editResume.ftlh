<#import "../layout.ftlh" as main>

<@main.layout ; spring>


    <h2><@spring.message "resumes.editResume.edit_resume"/></h2>
    <form action="/resumes/create" method="post">

        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf-param-name'}"
                   value="${(_csrf.token)!'csrf-token'}"/>
        </#if>

        <h3><@spring.message "resumes.editResume.resume_details"/></h3>
        <div id="resumesContainer">
            <div class="resume-entry mb-3">
                <div class="input-group mb-3">
                    <span class="input-group-text" id="resumeName"><@spring.message "resumes.editResume.resume_name"/></span>
                    <input type="text" class="form-control" aria-label="Resume Name" aria-describedby="name"
                           name="resumes.name" required>
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text" id="categoryId"><@spring.message "resumes.editResume.category_id"/></span>
                    <select class="form-select" aria-label="Category ID" aria-describedby="categoryId"
                            name="resumes.categories">
                        <option selected><@spring.message "resumes.editResume.open_this_select_menu"/></option>
                        <#list categoriesDto as item>
                            <option value="${item.id}">${item.name}</option>
                        </#list>
                    </select>
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text" id="salary"><@spring.message "resumes.editResume.salary"/></span>
                    <input type="number" step="0.01" class="form-control" aria-label="Salary" aria-describedby="salary"
                           name="resumes.salary">
                </div>
                <div class="form-check mb-3">
                    <input class="form-check-input" type="checkbox" id="isActive" name="resumes.isActive">
                    <label class="form-check-label" for="isActive">
                        <@spring.message "resumes.editResume.active"/>
                    </label>
                </div>
            </div>
        </div>

        <h3><@spring.message "resumes.editResume.work_experience"/></h3>
        <div id="workExperienceContainer">
            <div class="work-experience-entry mb-3">
                <div class="input-group mb-3">
                    <span class="input-group-text" id="companyName"><@spring.message "resumes.editResume.company_name"/></span>
                    <input type="text" class="form-control" aria-label="Company Name" aria-describedby="companyName"
                           name="workExperienceInfo.companyName" required>
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text" id="position"><@spring.message "resumes.editResume.position"/></span>
                    <input type="text" class="form-control" aria-label="Position" aria-describedby="position"
                           name="workExperienceInfo.position" required>
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text" id="year"><@spring.message "resumes.editResume.year"/></span>
                    <input type="number" class="form-control" aria-label="Year" aria-describedby="year"
                           name="workExperienceInfo.years" required>
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text" id="responsibilities"><@spring.message "resumes.editResume.responsibilities"/></span>
                    <textarea class="form-control" aria-label="Responsibilities" aria-describedby="responsibilities"
                              name="workExperienceInfo.responsibilities"></textarea>
                </div>
            </div>
        </div>

        <h3><@spring.message "resumes.editResume.education"/></h3>
        <div id="educationContainer">
            <div class="education-entry mb-3">
                <div class="input-group mb-3">
                    <span class="input-group-text" id="institution"><@spring.message "resumes.editResume.institution"/></span>
                    <input type="text" class="form-control" aria-label="Institution" aria-describedby="institution"
                           name="educationInfo.institution" required>
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text" id="program"><@spring.message "resumes.editResume.program"/></span>
                    <input type="text" class="form-control" aria-label="Program" aria-describedby="program"
                           name="educationInfo.program" required>
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text" id="startDate"><@spring.message "resumes.editResume.start_date"/></span>
                    <input type="date" class="form-control" aria-label="Start Date" aria-describedby="startDate"
                           name="educationInfo.startDate" required>
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text" id="endDate"><@spring.message "resumes.editResume.end_date"/></span>
                    <input type="date" class="form-control" aria-label="End Date" aria-describedby="endDate"
                           name="educationInfo.endDate" required>
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text" id="degree"><@spring.message "resumes.editResume.degree"/></span>
                    <input type="text" class="form-control" aria-label="Degree" aria-describedby="degree"
                           name="educationInfo.degree">
                </div>
            </div>
        </div>

        <h3><@spring.message "resumes.editResume.contacts"/></h3>
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

</@main.layout>