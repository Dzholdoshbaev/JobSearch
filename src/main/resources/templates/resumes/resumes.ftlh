<#import "../layout.ftlh" as main>

<@main.layout>

    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <#if resumes.hasPrevious()>
                <li class="page-item"><a class="page-link" href="/resumes?page=${resumes.number - 1}">Previous</a></li>
            <#else>
                <li class="page-item disabled"><a class="page-link" href="#">Previous</a></li>
            </#if>

            <#list 0..(resumes.totalPages - 1) as page>
                <li class="page-item <#if resumes.number == page>active</#if>">
                    <a class="page-link" href="/resumes?page=${page}">${page + 1}</a>
                </li>
            </#list>

            <#if resumes.hasNext()>
                <li class="page-item"><a class="page-link" href="/resumes?page=${resumes.number + 1}">Next</a></li>
            <#else>
                <li class="page-item disabled"><a class="page-link" href="#">Next</a></li>
            </#if>
        </ul>
    </nav>

    <div class="row d-flex justify-content-between">
        <#list resumes.content as resume>
            <div class="card col-6 m-2" style="width: 18rem;">
                <div class="card-body">
                    <h5 class="card-title">${resume.name!"Not specified"}</h5>
                    <p class="card-text">${resume.createdDate!"Not specified"}</p>
                    <p class="card-text">${resume.updateTime!"Not updated yet"}</p>
                    <#if resume.isActive>
                        <p class="card-text">Resume is active</p>
                    <#else>
                        <p class="card-text">Resume is not active</p>
                    </#if>
                    <a href="/resumes/${resume.id}" class="btn btn-primary">More Info</a>
                </div>
            </div>
        </#list>
    </div>

</@main.layout>
