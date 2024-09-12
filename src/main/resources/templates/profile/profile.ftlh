<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><@spring.message "profile.profile.profile"/></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .profile-container {
            margin-top: 30px;
        }
        .profile-img {
            width: 150px;
            height: 150px;
            object-fit: cover;
            border-radius: 50%;
            border: 2px solid #ddd;
            margin-bottom: 15px;
        }
        .form-control-file {
            border: 1px solid #ced4da;
            border-radius: 0.25rem;
        }
        .btn-outline-info {
            margin-top: 10px;
        }
        .card-title {
            font-size: 1.5rem;
        }
        .card-text {
            font-size: 1rem;
        }
    </style>
</head>

<header>
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <#if userDto.authorities.id == 1>
                        <a class="nav-link active" aria-current="page" href="/vacancies"><@spring.message "profile.profile.vacancies"/></a>
                    <#else>
                        <a class="nav-link" href="/resumes"><@spring.message "profile.profile.resumes"/></a>
                    </#if>
                </div>
            </div>
        </div>
        <#assign known = SPRING_SECURITY_CONTEXT?? >
        <#if known>
            <#assign
            user = SPRING_SECURITY_CONTEXT.authentication.principal
            name = user.getUsername()
            >
            <a href="/profile" class="text-dark m-2 m-sm-0">
                <span class="btn btn-outline-info m-2"><@spring.message "profile.profile.profile"/></span>
            </a>

            <#if _csrf??>

                <form action="/auth/logout" method="post">

                    <input type="hidden" name="${(_csrf.parameterName)!'csrf'}"

                           value="${(_csrf.token)!'--no-token--'}"/>

                    <button type="submit" class="btn btn-outline-info m-2" id="logout"><@spring.message "profile.profile.logout"/></button>

                </form>

            <#else>

                <a href="/auth/logout" class="btn btn-outline-info m-2" id="logout"><@spring.message "profile.profile.logout"/></a>

            </#if>

        <#else>
            <a href="/auth/login"
               class="btn btn-outline-info m-2"><@spring.message "profile.profile.login"/></a>
            <a href="profile/register"
               class="btn btn-outline-info m-2"><@spring.message "profile.profile.register"/></a>
        </#if>

    </nav>
</header>

<body>
<div class="container profile-container">
    <div class="row">
        <div class="col-md-4 text-center">
            <#if userDto??>
                <#if userDto.avatar?? && userDto.avatar?has_content>
                    <img src="./images/${userDto.avatar}" alt="ProfilePhoto" class="profile-img"/>
                <#else>
                    <img src="/static/images/nophoto.jpg" alt="ProfilePhoto" class="profile-img"/>
                </#if>
            <#else>
                <img src="/static/images/nophoto.jpg" alt="ProfilePhoto" class="profile-img"/>
            </#if>

            <form action="/images" method="post" enctype="multipart/form-data" class="mt-3">
                <#if _csrf??>
                    <input type="hidden" name="${(_csrf.parameterName)!'csrf-param-name'}"
                           value="${(_csrf.token)!'csrf-token'}"/>
                </#if>
                <input type="file" name="file"/>
                <button type="submit" class="btn btn-outline-info"><@spring.message "profile.profile.change_photo"/></button>
            </form>
        </div>
        <div class="col-md-8">
            <h3 class="card-title"><@spring.message "profile.profile.full_name"/> : ${userDto.name!""} ${userDto.surname!""}</h3>
            <p class="card-text"><strong><@spring.message "profile.profile.age"/>:</strong> ${userDto.age!""}</p>
            <p class="card-text"><strong><@spring.message "profile.profile.email"/>:</strong> ${userDto.email!""}</p>
            <p class="card-text"><strong><@spring.message "profile.profile.phone_number"/>:</strong> ${userDto.phoneNumber!""}</p>
            <#if userDto.authorities.id == 1>
                <p class="card-text"><@spring.message "profile.profile.applicant"/></p>
            <#else>
                <p class="card-text"><@spring.message "profile.profile.employer"/></p>
            </#if>
            <a href="profile/edit" class="btn btn-outline-info mt-3"><@spring.message "profile.profile.edit_profile"/></a>
            <#if userDto.authorities.id == 1>
                <div class="col col-12 col-md-4 colpost">
                    <a href="/resumes/create" class="btn btn-outline-info mt-3"><@spring.message "profile.profile.created_resume"/></a>
                </div>
                <div class="col col-12 col-md-4 colpost">
                    <a href="/applicants/resume" class="btn btn-outline-info mt-3"><@spring.message "profile.profile.responds"/></a>
                </div>
            <#else>
                <div class="col col-12 col-md-4 colpost">
                    <a href="/vacancies/create" class="btn btn-outline-info mt-3"><@spring.message "profile.profile.created_vacancy"/></a>
                </div>
            </#if>
        </div>
    </div>
</div>


    <#if userDto.authorities.id == 1>

        <h5 class="allResumes"><@spring.message "profile.profile.resumes"/> : </h5>

        <div class="row d-flex justify-content-between">
            <#list resumes as resume>
                <div class="card col-6 m-2" style="width: 18rem;">
                    <div class="card-body">
                        <h5 class="card-title"><@spring.message "profile.profile.title"/> :${resume.name!""}</h5>
                        <p class="card-text"><@spring.message "profile.profile.created_date"/> : ${resume.createdDate!""}</p>
                        <p class="card-text"><@spring.message "profile.profile.categories"/> : ${resume.categories.name!""}</p>
                        <p class="card-text"><@spring.message "profile.profile.update_time"/> : ${resume.updateTime!""}</p>
                        <#if resume.isActive>
                            <p class="card-text"><@spring.message "profile.profile.resume_is_active"/></p>
                        <#else>
                            <p class="card-text"><@spring.message "profile.profile.resume_is_not_active"/></p>
                        </#if>
                        <a href="/resumes/edit/${resume.id}" class="btn btn-outline-info m-2"><@spring.message "profile.profile.edit_resumes"/></a>
                        <a href="/resumes/update/${resume.id}" class="btn btn-outline-info m-2"><@spring.message "profile.profile.update"/></a>
                    </div>
                </div>
            </#list>
        </div>


    <#else>

        <h5 class="allVacancy"><@spring.message "profile.profile.vacancies"/> : </h5>

        <div class="row d-flex justify-content-between">
            <#list vacancies as vacancy>
                <div class="card col-6 m-2" style="width: 18rem;">
                    <div class="card-body">
                        <h5 class="card-title"><@spring.message "profile.profile.title"/> : ${vacancy.name!""}</h5>
                        <p class="card-text"><@spring.message "profile.profile.description"/> : ${vacancy.description!""}</p>
                        <p class="card-text"><@spring.message "profile.profile.created_date"/>  : ${vacancy.createdDate!""}</p>
                        <p class="card-text"><@spring.message "profile.profile.categories"/> : ${vacancy.categories.name!""}</p>
                        <#if vacancy.isActive>
                            <p class="card-text"><@spring.message "profile.profile.vacancy_is_active"/></p>
                        <#else>
                            <p class="card-text"><@spring.message "profile.profile.vacancy_is_not_active"/></p>
                        </#if>
                        <p class="card-text"><@spring.message "profile.profile.expected_salary"/> : ${vacancy.salary!""}</p>
                        <p class="card-text"><@spring.message "profile.profile.update_time"/> : ${vacancy.updateTime!""}</p>
                        <p class="card-text"><@spring.message "profile.profile.exp_from"/> : ${vacancy.expFrom!""}</p>
                        <p class="card-text"><@spring.message "profile.profile.exp_to"/> : ${vacancy.expTo!""}</p>
                        <a href="/vacancies/edit/${vacancy.id}" class="btn btn-outline-info m-2"><@spring.message "profile.profile.edit_vacancy"/></a>
                        <a href="vacancies/update/${vacancy.id}" class="btn btn-outline-info m-2"><@spring.message "profile.profile.update"/></a>
                    </div>
                </div>
            </#list>
        </div>

    </#if>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>