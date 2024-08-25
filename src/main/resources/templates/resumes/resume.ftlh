<#import "../layout.ftlh" as main>

<@main.layout>


    <div class="row d-flex justify-content-between">
            <div class="card col-6 m-2" style="width: 18rem;">
                <div class="card-body">
                    <h5 class="card-title">${resume.name}</h5>
                    <p class="card-text">${resume.createdDate}</p>
                    <p class="card-text">${resume.categories.name}</p>
                    <#if resume.isActive>
                        <p class="card-text">Resume is active</p>
                    <#else>
                        <p class="card-text">Resume is not active</p>
                    </#if>
                    <p class="card-text">${resume.salary}</p>
                    <p class="card-text">${resume.updateTime!"Not update yet"}</p>
                    <a href="/profile" class="btn btn-primary">Back to Profile</a>
                </div>
            </div>
    </div>

    <div class="row d-flex justify-content-between">
        <div class="card col-6 m-2" style="width: 18rem;">
            <div class="card-body">
                <h5 class="card-title">${educationInfo.institution}</h5>
                <p class="card-text">${educationInfo.program}</p>
                <p class="card-text">${educationInfo.startDate}</p>
                <p class="card-text">${educationInfo.endDate}</p>
                <p class="card-text">${educationInfo.degree}</p>
            </div>
        </div>
    </div>

    <div class="row d-flex justify-content-between">
        <div class="card col-6 m-2" style="width: 18rem;">
            <div class="card-body">
                <h5 class="card-title">${workExperienceInfo.position}</h5>
                <p class="card-text">${workExperienceInfo.companyName}</p>
                <p class="card-text">${workExperienceInfo.responsibilities}</p>
                <p class="card-text">${workExperienceInfo.years}</p>
            </div>
        </div>
    </div>

    <div class="row d-flex justify-content-between">
        <#list contactsInfoList as contacts>
            <#if contacts.contactTypes.id == 1>
                <div class="card col-6 m-2" style="width: 18rem;">
                    <div class="card-body">
                        <h5 class="card-title">Email</h5>
                        <p class="card-text">${contacts.info}</p>
                    </div>
                </div>
            </#if>
            <#if contacts.contactTypes.id == 2>
                <div class="card col-6 m-2" style="width: 18rem;">
                    <div class="card-body">
                        <h5 class="card-title">Phone</h5>
                        <p class="card-text">${contacts.info}</p>
                    </div>
                </div>
            </#if>
            <#if contacts.contactTypes.id == 3>
                <div class="card col-6 m-2" style="width: 18rem;">
                    <div class="card-body">
                        <h5 class="card-title">Telegram</h5>
                        <p class="card-text">${contacts.info}</p>
                    </div>
                </div>
            </#if>
            <#if contacts.contactTypes.id == 4>
                <div class="card col-6 m-2" style="width: 18rem;">
                    <div class="card-body">
                        <h5 class="card-title">Facebook</h5>
                        <p class="card-text">${contacts.info}</p>
                    </div>
                </div>
            </#if>
            <#if contacts.contactTypes.id == 5>
                <div class="card col-6 m-2" style="width: 18rem;">
                    <div class="card-body">
                        <h5 class="card-title">LinkedIn</h5>
                        <p class="card-text">${contacts.info}</p>
                    </div>
                </div>
            </#if>
        </#list>
    </div>




</@main.layout>