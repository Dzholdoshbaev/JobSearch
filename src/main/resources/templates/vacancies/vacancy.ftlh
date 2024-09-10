<#import "../layout.ftlh" as main>

<@main.layout>




    <div class="container my-4">
        <div class="row d-flex justify-content-center">
            <div class="card col-md-8 col-lg-6 mb-4 shadow-sm">
                <div class="card-body">
                    <h5 class="card-title">${vacancy.name!"Not specified"}</h5>
                    <p class="card-text">${vacancy.description!"Not specified"}</p>
                    <p class="card-text"><strong>Salary:</strong> ${vacancy.salary!"Not specified"}</p>
                    <p class="card-text"><strong>Status:</strong>
                        <#if vacancy.isActive>
                            Vacancy is active
                        <#else>
                            Vacancy is not active
                        </#if>
                    </p>
                    <p class="card-text"><strong>Categories:</strong> ${vacancy.categories.name!"Not specified"}</p>
                    <p class="card-text"><strong>Created Date:</strong> ${vacancy.createdDate!"Not specified"}</p>
                    <p class="card-text"><strong>Update Time:</strong> ${vacancy.updateTime!"Not updated yet"}</p>
                    <p class="card-text"><strong>Experience From:</strong> ${vacancy.expFrom!"Not specified"}</p>
                    <p class="card-text"><strong>Experience To:</strong> ${vacancy.expTo!"Not specified"}</p>
                    <div class="d-flex justify-content-between mt-4">
                        <a href="#" class="btn btn-outline-info m-2">Respond to Vacancy</a>
                        <a href="/vacancies" class="btn btn-outline-info m-2">Back to Vacancies</a>
                    </div>
                </div>
            </div>
        </div>
    </div>



</@main.layout>