<#import "../layout.ftlh" as main>

<@main.layout>

    <div class="container mt-5">
        <h2 class="mb-4 d-flex align-items-center">
            <a href="/resumes" class="btn btn-outline-info m-2">Back to Resumes</a>
            Resume Details
        </h2>
        <!-- Resume Information -->
        <div class="row mb-4">
            <div class="col-12">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">${resume.name!"Not specified"}</h5>
                        <p class="card-text"><strong>Created Date:</strong> ${resume.createdDate!"Not specified"}</p>
                        <p class="card-text"><strong>Categories:</strong> ${resume.categories.name!"Not specified"}</p>
                        <p class="card-text">
                            <strong>Status:</strong>
                            <#if resume.isActive>
                                Resume is active
                            <#else>
                                Resume is not active
                            </#if>
                        </p>
                        <p class="card-text"><strong>Salary Expected:</strong> ${resume.salary!"Not specified"}</p>
                        <p class="card-text"><strong>Update Time:</strong> ${resume.updateTime!"Not update yet"}</p>
                    </div>
                </div>
            </div>
        </div>

        <!-- Education Information -->
        <div class="row mb-4">
            <div class="col-12">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Education Information</h5>
                        <p class="card-text"><strong>Institution:</strong> ${educationInfo.institution!"Not specified"}</p>
                        <p class="card-text"><strong>Program:</strong> ${educationInfo.program!"Not specified"}</p>
                        <p class="card-text"><strong>Start Date:</strong> ${educationInfo.startDate!"Not specified"}</p>
                        <p class="card-text"><strong>Graduated:</strong> ${educationInfo.endDate!"Not specified"}</p>
                        <p class="card-text"><strong>Degree:</strong> ${educationInfo.degree!"Not specified"}</p>
                    </div>
                </div>
            </div>
        </div>

        <!-- Work Experience Information -->
        <div class="row mb-4">
            <div class="col-12">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Work Experience</h5>
                        <p class="card-text"><strong>Position:</strong> ${workExperienceInfo.position!"Not specified"}</p>
                        <p class="card-text"><strong>Company Name:</strong> ${workExperienceInfo.companyName!"Not specified"}</p>
                        <p class="card-text"><strong>Responsibilities:</strong> ${workExperienceInfo.responsibilities!"Not specified"}</p>
                        <p class="card-text"><strong>Experience:</strong> ${workExperienceInfo.years!"Not specified"}</p>
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
                                <h5 class="card-title text-primary">Email</h5>
                                <p class="card-text">${contacts.info!"Not specified"}</p>
                            </div>
                        </div>
                    </div>
                </#if>
                <#if contacts.contactTypes.id == 2>
                    <div class="col-md-6 col-lg-4 mb-4">
                        <div class="card h-100 shadow-sm">
                            <div class="card-body">
                                <h5 class="card-title text-success">Phone</h5>
                                <p class="card-text">${contacts.info!"Not specified"}</p>
                            </div>
                        </div>
                    </div>
                </#if>
                <#if contacts.contactTypes.id == 3>
                    <div class="col-md-6 col-lg-4 mb-4">
                        <div class="card h-100 shadow-sm">
                            <div class="card-body">
                                <h5 class="card-title text-info">Telegram</h5>
                                <p class="card-text">${contacts.info!"Not specified"}</p>
                            </div>
                        </div>
                    </div>
                </#if>
                <#if contacts.contactTypes.id == 4>
                    <div class="col-md-6 col-lg-4 mb-4">
                        <div class="card h-100 shadow-sm">
                            <div class="card-body">
                                <h5 class="card-title text-warning">Facebook</h5>
                                <p class="card-text">${contacts.info!"Not specified"}</p>
                            </div>
                        </div>
                    </div>
                </#if>
                <#if contacts.contactTypes.id == 5>
                    <div class="col-md-6 col-lg-4 mb-4">
                        <div class="card h-100 shadow-sm">
                            <div class="card-body">
                                <h5 class="card-title text-dark">LinkedIn</h5>
                                <p class="card-text">${contacts.info!"Not specified"}</p>
                            </div>
                        </div>
                    </div>
                </#if>
            </#list>
        </div>
    </div>




</@main.layout>