<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"
          name="viewport">
    <meta content="ie=edge" http-equiv="X-UA-Compatible">
    <title>Job Search</title>
    <link href="#" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>

<body>

<header>
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <#if userDto.authorities.id == 1>
                        <a class="nav-link active" aria-current="page" href="/vacancies">Vacancies</a>
                    <#else>
                        <a class="nav-link" href="/resumes">Resumes</a>
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
            <a href="/profile/${name}" class="text-light m-2 m-sm-0">
                Hello, ${name}:
                <#list user.authorities as auth>
                    <span class="text-danger">${auth}</span>
                    <#if auth?has_next>
                        /
                    </#if>
                </#list>
            </a>

            <a href="/auth/logout" class="btn btn-outline-info m-2"
               id="logout">Logout</a>

        <#else>
            <a href="/auth/login"
               class="btn btn-outline-info m-2">Login</a>
            <a href="profile/register"
               class="btn btn-outline-info m-2">Register</a>
        </#if>

    </nav>
</header>

<div class="container">

    <div class="row backpost">
        <form action="/images" method="post" enctype="multipart/form-data">
            <div class="col col-12 col-md-6 colpost">
                <img src="<#if userDto.avatar?? && (userDto.avatar != '')>/images/${userDto.avatar}<#else>/static/images/nophoto.jpg</#if>" alt="ProfilePhoto"/>
                <div class="file btn btn-lg btn-primary">
                    Change Photo
                    <input type="file" name="file"/>
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Change Photo</button>
        </form>

        <div class="col col-12 col-md-6 colpost">

            <div class="col col-12 col-md-4 colpost">
                <h5 class="card-title">${userDto.name}  ${userDto.surname}</h5>
                <p class="card-text">${userDto.age}</p>
                <p class="card-text">${userDto.email}</p>
                <p class="card-text">${userDto.phoneNumber!"User Without Phone"}</p>
                <#if userDto.authorities.id == 1>
                    <p class="card-text">APPLICANT</p>
                    <#else>
                        <p class="card-text">EMPLOYER</p>
                </#if>

                <a href="profile/edit" class="btn btn-primary">Edit profile</a>
            </div>

            <#if userDto.authorities.id == 1>
                <div class="col col-12 col-md-4 colpost">
                    <a href="/resumes/create" class="btn btn-primary">Created resume</a>
                </div>
                <div class="col col-12 col-md-4 colpost">
                    <a href="/applicants/resume" class="btn btn-primary">Responds</a>
                </div>
            <#else>
                <div class="col col-12 col-md-4 colpost">
                    <a href="/vacancies/create" class="btn btn-primary">Created vacancy</a>
                </div>
            </#if>

        </div>

    </div>

    <#if userDto.authorities.id == 1>

        <h5 class="allResumes">Resumes : </h5>

        <div class="row d-flex justify-content-between">
            <#list resumes as resume>
                <div class="card col-6 m-2" style="width: 18rem;">
                    <div class="card-body">
                        <h5 class="card-title">${resume.name}</h5>
                        <p class="card-text">${resume.createdDate}</p>
                        <p class="card-text">${resume.categories.name}</p>
                        <p class="card-text">${resume.updateTime!"Not update yet"}</p>
                        <#if resume.isActive>
                            <p class="card-text">Resume is active</p>
                        <#else>
                            <p class="card-text">Resume is not active</p>
                        </#if>
                        <a href="/resumes/edit/${resume.id}" class="btn btn-primary">Edit Resumes</a>
                        <a href="/resumes/update/${resume.id}" class="btn btn-primary">Update</a>
                    </div>
                </div>
            </#list>
        </div>


    <#else>

        <h5 class="allVacancy">Vacancies : </h5>

        <div class="row d-flex justify-content-between">
            <#list vacancies as vacancy>
                <div class="card col-6 m-2" style="width: 18rem;">
                    <div class="card-body">
                        <h5 class="card-title">${vacancy.name}</h5>
                        <p class="card-text">${vacancy.description}</p>
                        <p class="card-text">${vacancy.createdDate}</p>
                        <p class="card-text">${vacancy.categories.name}</p>
                        <#if vacancy.isActive>
                            <p class="card-text">vacancy is active</p>
                        <#else>
                            <p class="card-text">vacancy is not active</p>
                        </#if>
                        <p class="card-text">${vacancy.salary}</p>
                        <p class="card-text">${vacancy.updateTime!"Not update yet"}</p>
                        <p class="card-text">${vacancy.expFrom}</p>
                        <p class="card-text">${vacancy.expTo}</p>
                        <a href="/vacancies/edit/${vacancy.id}" class="btn btn-primary">Edit vacancy</a>
                        <a href="vacancies/update/${vacancy.id}" class="btn btn-primary">Update</a>
                    </div>
                </div>
            </#list>
        </div>

    </#if>

</div>

</body>
</html>