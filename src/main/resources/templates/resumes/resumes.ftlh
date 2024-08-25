<#import "../layout.ftlh" as main>

<@main.layout>




    <div class="row d-flex justify-content-between">
        <#list resumes as resume>
            <div class="card col-6 m-2" style="width: 18rem;">
                <div class="card-body">
                    <h5 class="card-title">${resume.name}</h5>
                    <p class="card-text">${resume.createdDate}</p>
                    <p class="card-text">${resume.updateTime!"Not update yet"}</p>
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