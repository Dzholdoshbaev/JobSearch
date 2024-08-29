<#import "../layout.ftlh" as main>

<@main.layout>


    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <#if vacancies.hasPrevious()>
                <li class="page-item"><a class="page-link" href="/vacancies?page=${vacancies.number - 1}">Previous</a></li>
            <#else>
                <li class="page-item disabled"><a class="page-link" href="#">Previous</a></li>
            </#if>

            <#list 0..(vacancies.totalPages - 1) as page>
                <li class="page-item <#if vacancies.number == page>active</#if>">
                    <a class="page-link" href="/vacancies?page=${page}">${page + 1}</a>
                </li>
            </#list>

            <#if vacancies.hasNext()>
                <li class="page-item"><a class="page-link" href="/vacancies?page=${vacancies.number + 1}">Next</a></li>
            <#else>
                <li class="page-item disabled"><a class="page-link" href="#">Next</a></li>
            </#if>
        </ul>
    </nav>



    <div class="row">
        <#list vacancies.content as vacancy>
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