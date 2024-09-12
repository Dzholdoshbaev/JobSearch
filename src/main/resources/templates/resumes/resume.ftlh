<#import "../layout.ftlh" as main>

<@main.layout ; spring>

    <div class="container mt-5">
        <h2 class="mb-4 d-flex align-items-center">
            <a href="/resumes" class="btn btn-outline-info m-2"><@spring.message "resumes.resume.back_to_resumes"/></a>
            <@spring.message "resumes.resume.resume_details"/>
        </h2>
        <div class="row mb-4">
            <div class="col-12">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title"><@spring.message "resumes.resume.title"/> : ${resume.name!""}</h5>
                        <p class="card-text"><strong><@spring.message "resumes.resume.created_date"/>:</strong> ${resume.createdDate!""}</p>
                        <p class="card-text"><strong><@spring.message "resumes.resume.categories"/>:</strong> ${resume.categories.name!""}</p>
                        <p class="card-text">
                            <strong><@spring.message "resumes.resume.status"/>:</strong>
                            <#if resume.isActive>
                                <@spring.message "resumes.resume.resume_is_active"/>
                            <#else>
                                <@spring.message "resumes.resume.resume_is_not_active"/>
                            </#if>
                        </p>
                        <p class="card-text"><strong><@spring.message "resumes.resume.salary_expected"/>:</strong> ${resume.salary!""}</p>
                        <p class="card-text"><strong><@spring.message "resumes.resume.update_time"/>:</strong> ${resume.updateTime!""}</p>
                    </div>
                </div>
            </div>
        </div>

        <div class="row mb-4">
            <div class="col-12">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title"><@spring.message "resumes.resume.education_information"/></h5>
                        <p class="card-text"><strong><@spring.message "resumes.resume.institution"/>:</strong> ${educationInfo.institution!""}</p>
                        <p class="card-text"><strong><@spring.message "resumes.resume.program"/>:</strong> ${educationInfo.program!""}</p>
                        <p class="card-text"><strong><@spring.message "resumes.resume.start_date"/>:</strong> ${educationInfo.startDate!""}</p>
                        <p class="card-text"><strong><@spring.message "resumes.resume.graduated"/>:</strong> ${educationInfo.endDate!""}</p>
                        <p class="card-text"><strong><@spring.message "resumes.resume.degree"/>:</strong> ${educationInfo.degree!""}</p>
                    </div>
                </div>
            </div>
        </div>

        <div class="row mb-4">
            <div class="col-12">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title"><@spring.message "resumes.resume.work_experience"/></h5>
                        <p class="card-text"><strong><@spring.message "resumes.resume.position"/>:</strong> ${workExperienceInfo.position!""}</p>
                        <p class="card-text"><strong><@spring.message "resumes.resume.company_name"/>:</strong> ${workExperienceInfo.companyName!""}</p>
                        <p class="card-text"><strong><@spring.message "resumes.resume.responsibilities"/>:</strong> ${workExperienceInfo.responsibilities!""}</p>
                        <p class="card-text"><strong><@spring.message "resumes.resume.experience"/>:</strong> ${workExperienceInfo.years!""}</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="container my-4">
        <div class="row">
            <#list contactsInfoList as contacts>
                <#if contacts.contactTypes.id == 1>
                    <div class="col-md-6 col-lg-4 mb-4">
                        <div class="card h-100 shadow-sm">
                            <div class="card-body">
                                <h5 class="card-title text-primary"><@spring.message "resumes.resume.email"/></h5>
                                <p class="card-text">${contacts.info!""}</p>
                            </div>
                        </div>
                    </div>
                </#if>
                <#if contacts.contactTypes.id == 2>
                    <div class="col-md-6 col-lg-4 mb-4">
                        <div class="card h-100 shadow-sm">
                            <div class="card-body">
                                <h5 class="card-title text-success"><@spring.message "resumes.resume.phone"/></h5>
                                <p class="card-text">${contacts.info!""}</p>
                            </div>
                        </div>
                    </div>
                </#if>
                <#if contacts.contactTypes.id == 3>
                    <div class="col-md-6 col-lg-4 mb-4">
                        <div class="card h-100 shadow-sm">
                            <div class="card-body">
                                <h5 class="card-title text-info"><@spring.message "resumes.resume.telegram"/></h5>
                                <p class="card-text">${contacts.info!""}</p>
                            </div>
                        </div>
                    </div>
                </#if>
                <#if contacts.contactTypes.id == 4>
                    <div class="col-md-6 col-lg-4 mb-4">
                        <div class="card h-100 shadow-sm">
                            <div class="card-body">
                                <h5 class="card-title text-warning"><@spring.message "resumes.resume.facebook"/></h5>
                                <p class="card-text">${contacts.info!""}</p>
                            </div>
                        </div>
                    </div>
                </#if>
                <#if contacts.contactTypes.id == 5>
                    <div class="col-md-6 col-lg-4 mb-4">
                        <div class="card h-100 shadow-sm">
                            <div class="card-body">
                                <h5 class="card-title text-dark"><@spring.message "resumes.resume.linkedIn"/></h5>
                                <p class="card-text">${contacts.info!""}</p>
                            </div>
                        </div>
                    </div>
                </#if>
            </#list>
        </div>
    </div>




</@main.layout>