<#import "../layout.ftlh" as main>

<@main.layout>


    <div class="row d-flex justify-content-between">
            <div class="card col-6 m-2" style="width: 18rem;">
                <div class="card-body">
                    <h5 class="card-title">${resume.name!"Not specified"}</h5>
                    <p class="card-text">Created Date ${resume.createdDate!"Not specified"}</p>
                    <p class="card-text">Categories ${resume.categories.name!"Not specified"}</p>
                    <#if resume.isActive>
                        <p class="card-text">Resume is active</p>
                    <#else>
                        <p class="card-text">Resume is not active</p>
                    </#if>
                    <p class="card-text">Salary Expected ${resume.salary!"Not specified"}</p>
                    <p class="card-text">Update Time ${resume.updateTime!"Not update yet"}</p>
                    <a href="/profile" class="btn btn-primary">Back to Profile</a>
                </div>
            </div>
    </div>

    <div class="row d-flex justify-content-between">
        <div class="card col-6 m-2" style="width: 18rem;">
            <div class="card-body">
                <h5 class="card-title">Institution ${educationInfo.institution!"Not specified"}</h5>
                <p class="card-text">Institution Program ${educationInfo.program!"Not specified"}</p>
                <p class="card-text">Start Date ${educationInfo.startDate!"Not specified"}</p>
                <p class="card-text">Graduated ${educationInfo.endDate!"Not specified"}</p>
                <p class="card-text">Degree ${educationInfo.degree!"Not specified"}</p>
            </div>
        </div>
    </div>

    <div class="row d-flex justify-content-between">
        <div class="card col-6 m-2" style="width: 18rem;">
            <div class="card-body">
                <h5 class="card-title">Position ${workExperienceInfo.position!"Not specified"}</h5>
                <p class="card-text">Company Name ${workExperienceInfo.companyName!"Not specified"}</p>
                <p class="card-text">Responsibilities ${workExperienceInfo.responsibilities!"Not specified"}</p>
                <p class="card-text">Experience ${workExperienceInfo.years!"Not specified"}</p>
            </div>
        </div>
    </div>

    <div class="row d-flex justify-content-between">
        <#list contactsInfoList as contacts>
            <#if contacts.contactTypes.id == 1>
                <div class="card col-6 m-2" style="width: 18rem;">
                    <div class="card-body">
                        <h5 class="card-title">Email</h5>
                        <p class="card-text">${contacts.info!"Not specified"}</p>
                    </div>
                </div>
            </#if>
            <#if contacts.contactTypes.id == 2>
                <div class="card col-6 m-2" style="width: 18rem;">
                    <div class="card-body">
                        <h5 class="card-title">Phone</h5>
                        <p class="card-text">${contacts.info!"Not specified"}</p>
                    </div>
                </div>
            </#if>
            <#if contacts.contactTypes.id == 3>
                <div class="card col-6 m-2" style="width: 18rem;">
                    <div class="card-body">
                        <h5 class="card-title">Telegram</h5>
                        <p class="card-text">${contacts.info!"Not specified"}</p>
                    </div>
                </div>
            </#if>
            <#if contacts.contactTypes.id == 4>
                <div class="card col-6 m-2" style="width: 18rem;">
                    <div class="card-body">
                        <h5 class="card-title">Facebook</h5>
                        <p class="card-text">${contacts.info!"Not specified"}</p>
                    </div>
                </div>
            </#if>
            <#if contacts.contactTypes.id == 5>
                <div class="card col-6 m-2" style="width: 18rem;">
                    <div class="card-body">
                        <h5 class="card-title">LinkedIn</h5>
                        <p class="card-text">${contacts.info!"Not specified"}</p>
                    </div>
                </div>
            </#if>
        </#list>
    </div>




</@main.layout>