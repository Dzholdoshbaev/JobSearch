<#import "../layout.ftlh" as main>

<@main.layout ; spring>

    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <#if resumes.hasPrevious()>
                <li class="page-item"><a class="page-link" href="/resumes?page=${resumes.number - 1}"><@spring.message "resumes.resumes.previous"/></a></li>
            <#else>
                <li class="page-item disabled"><a class="page-link" href="#"><@spring.message "resumes.resumes.previous"/></a></li>
            </#if>

            <#list 0..(resumes.totalPages - 1) as page>
                <li class="page-item <#if resumes.number == page>active</#if>">
                    <a class="page-link" href="/resumes?page=${page}">${page + 1}</a>
                </li>
            </#list>

            <#if resumes.hasNext()>
                <li class="page-item"><a class="page-link" href="/resumes?page=${resumes.number + 1}"><@spring.message "resumes.resumes.next"/></a></li>
            <#else>
                <li class="page-item disabled"><a class="page-link" href="#"><@spring.message "resumes.resumes.next"/></a></li>
            </#if>
        </ul>
    </nav>

    <div class="row d-flex justify-content-between">
        <#list resumes.content as resume>
            <div class="card col-6 m-2" style="width: 18rem;">
                <div class="card-body">
                    <h5 class="card-title"><@spring.message "resumes.resumes.title"/> :${resume.name!""}</h5>
                    <p class="card-text"><@spring.message "resumes.resumes.created_date"/> : ${resume.createdDate!""}</p>
                    <p class="card-text"><@spring.message "resumes.resumes.update_time"/> : ${resume.updateTime!""}</p>
                    <#if resume.isActive>
                        <p class="card-text"><@spring.message "resumes.resumes.resume_is_active"/></p>
                    <#else>
                        <p class="card-text"><@spring.message "resumes.resumes.resume_is_not_active"/></p>
                    </#if>
                    <a href="/resumes/${resume.id}" class="btn btn-outline-info m-2"><@spring.message "resumes.resumes.more_info"/></a>
                </div>
            </div>
        </#list>
    </div>

</@main.layout>
