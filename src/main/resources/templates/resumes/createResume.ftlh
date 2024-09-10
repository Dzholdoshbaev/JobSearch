<#import "../layout.ftlh" as main>

<@main.layout ; spring>


<h2>Create Resume</h2>
<form action="/resumes/create" method="post">

    <#if _csrf??>
        <input type="hidden" name="${(_csrf.parameterName)!'csrf-param-name'}"
               value="${(_csrf.token)!'csrf-token'}"/>
    </#if>

    <h3>Resume Details</h3>
    <div id="resumesContainer">
        <div class="resume-entry mb-3">
            <div class="input-group mb-3">
                <span class="input-group-text" id="resumeName">Resume Name</span>
                <input type="text" class="form-control" aria-label="Resume Name" aria-describedby="name"
                       name="resumes.name" required>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text" id="categoryId">Category ID</span>
                <select class="form-select" aria-label="Category ID" aria-describedby="categoryId"
                        name="resumes.categories">
                    <option selected>Open this select menu</option>
                    <#list categoriesDto as item>
                        <option value="${item.id}">${item.name}</option>
                    </#list>
                </select>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text" id="salary">Salary</span>
                <input type="number" step="0.01" class="form-control" aria-label="Salary" aria-describedby="salary"
                       name="resumes.salary">
            </div>
            <div class="form-check mb-3">
                <input class="form-check-input" type="checkbox" id="isActive" name="resumes.isActive">
                <label class="form-check-label" for="isActive">
                    Active
                </label>
            </div>
        </div>
    </div>

    <h3>Work Experience</h3>
    <div id="workExperienceContainer">
        <div class="work-experience-entry mb-3">
            <div class="input-group mb-3">
                <span class="input-group-text" id="companyName">Company Name</span>
                <input type="text" class="form-control" aria-label="Company Name" aria-describedby="companyName"
                       name="workExperienceInfo.companyName" required>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text" id="position">Position</span>
                <input type="text" class="form-control" aria-label="Position" aria-describedby="position"
                       name="workExperienceInfo.position" required>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text" id="year">Year</span>
                <input type="number" class="form-control" aria-label="Year" aria-describedby="year"
                       name="workExperienceInfo.years" required>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text" id="responsibilities">Responsibilities</span>
                <textarea class="form-control" aria-label="Responsibilities" aria-describedby="responsibilities"
                          name="workExperienceInfo.responsibilities"></textarea>
            </div>
        </div>
    </div>

    <h3>Education</h3>
    <div id="educationContainer">
        <div class="education-entry mb-3">
            <div class="input-group mb-3">
                <span class="input-group-text" id="institution">Institution</span>
                <input type="text" class="form-control" aria-label="Institution" aria-describedby="institution"
                       name="educationInfo.institution" required>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text" id="program">Program</span>
                <input type="text" class="form-control" aria-label="Program" aria-describedby="program"
                       name="educationInfo.program" required>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text" id="startDate">Start Date</span>
                <input type="date" class="form-control" aria-label="Start Date" aria-describedby="startDate"
                       name="educationInfo.startDate" required>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text" id="endDate">End Date</span>
                <input type="date" class="form-control" aria-label="End Date" aria-describedby="endDate"
                       name="educationInfo.endDate" required>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text" id="degree">Degree</span>
                <input type="text" class="form-control" aria-label="Degree" aria-describedby="degree"
                       name="educationInfo.degree">
            </div>
        </div>
    </div>

    <h3>Contacts</h3>
    <div id="contactsContainer">
        <#list contactTypes as type>
            <div class="contact-entry mb-3">
                <div class="input-group mb-3">
                    <span class="input-group-text">${type.type}</span>
                    <input type="text" class="form-control" aria-label="${type.type}"
                           name="contactsInfoList[${type.id - 1}].info" placeholder="Enter ${type.type} info">
                    <input type="hidden" name="contactsInfoList[${type.id - 1}].contactTypes.id" value="${type.id}">
                </div>
            </div>
        </#list>
    </div>






    <button type="submit" class="btn btn-primary mt-3">Create Resume</button>
</form>

</@main.layout>