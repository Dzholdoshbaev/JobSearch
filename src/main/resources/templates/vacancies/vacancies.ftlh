<#import "../layout.ftlh" as main>

<@main.layout>




    <div class="row">
        <#list vacancies as vacancy>
            <div class="col-12 mb-4">
                <div class="d-flex align-items-center p-3 border rounded">
                    <div class="flex-shrink-0 me-3">
                        <a href="/vacancies/${vacancy.id}" class="btn btn-primary">${vacancy.name!"Not specified"}</a>
                    </div>
                    <div class="flex-grow-1">
                        <p class="mb-1">Salary: ${vacancy.salary!"Not specified"}</p>
                        <p class="mb-1">Published on: ${vacancy.createdDate!"Not specified"}</p>
                    </div>
                    <div class="flex-shrink-0 ms-3">
                        <a href="/profile/company/${vacancy.users.id}" class="btn btn-primary">Check Company</a>
                        <a href="/profile" class="btn btn-primary">Back to Profile</a>
                    </div>
                </div>
            </div>
        </#list>
    </div>



</@main.layout>