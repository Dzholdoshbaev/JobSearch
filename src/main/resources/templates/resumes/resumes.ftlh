<#import "../layout.ftlh" as main>

<@main.layout>




    <div class="row d-flex justify-content-between">
        <#list resumes as resume>
            <div class="card col-6 m-2" style="width: 18rem;">
                <img src="/static/images/nophoto.jpg" class="card-img-top" alt="No image available">
                <div class="card-body">
                    <h5 class="card-title">${resume.name}</h5>
                    <p class="card-text">${resume.createdDate}</p>
                    <a href="#" class="btn btn-primary">More Info</a>
                </div>
            </div>
        </#list>
    </div>




</@main.layout>