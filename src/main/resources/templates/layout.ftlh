<#import "spring.ftl" as spring>
<#macro layout>

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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    </head>

    <body>

    <header>
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid">
                <a class="navbar-brand" href="/"><@spring.message "layout.home"/></a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
            </div>

            <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                    <@spring.message "layout.lang"/>
                </button>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="?lang=en"><@spring.message "layout.eng"/></a></li>
                    <li><a class="dropdown-item" href="?lang=ru"><@spring.message "layout.rus"/></a></li>
                </ul>
            </div>

            <#assign known = SPRING_SECURITY_CONTEXT?? >
            <#if known>
                <#assign
                user = SPRING_SECURITY_CONTEXT.authentication.principal
                name = user.getUsername()
                >
                <a href="/profile" class="text-dark m-2 m-sm-0">
                    <span class="btn btn-outline-info m-2"><@spring.message "layout.profile"/></span>
                </a>

                <#if _csrf??>

                    <form action="/auth/logout" method="post">

                        <input type="hidden" name="${(_csrf.parameterName)!'csrf'}"

                               value="${(_csrf.token)!'--no-token--'}"/>

                        <button type="submit" class="btn btn-outline-info m-2" id="logout"><@spring.message "layout.logout"/></button>

                    </form>

                <#else>

                    <a href="/auth/logout" class="btn btn-outline-info m-2" id="logout"><@spring.message "layout.logout"/></a>

                </#if>

            <#else>
                <a href="/auth/login"
                   class="btn btn-outline-info m-2"><@spring.message "layout.login"/></a>
                <a href="/profile/register"
                   class="btn btn-outline-info m-2"><@spring.message "layout.register"/></a>
            </#if>

        </nav>
    </header>

    <div class="container">

        <#nested spring>

    </div>

    </body>
    </html>
</#macro>