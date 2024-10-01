<#import "../layout.ftlh" as main>
<@main.layout ; spring>

    <#assign sort = sort! "createdDate">

    <form id="filterForm" method="get" action="/vacancies">
        <div class="form-group">
            <label for="sort"><@spring.message "vacancies.vacancies.sort_by"/>:</label>
            <select id="sort" name="sort" class="form-control" onchange="updateFilter()">
                <option value="createdDate" <#if sort == "createdDate">selected</#if>><@spring.message "vacancies.vacancies.publication_date"/></option>
                <option value="respondAmount" <#if sort == "respondAmount">selected</#if>><@spring.message "vacancies.vacancies.amount_of_responses"/></option>
            </select>
        </div>
    </form>

    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <#if vacancies.hasPrevious()>
                <li class="page-item"><a class="page-link" href="?page=${vacancies.number - 1}&sort=${sort}"><@spring.message "vacancies.vacancies.previous"/></a></li>
            <#else>
                <li class="page-item disabled"><a class="page-link" href="#"><@spring.message "vacancies.vacancies.previous"/></a></li>
            </#if>

            <#list 0..(vacancies.totalPages - 1) as page>
                <li class="page-item <#if vacancies.number == page>active</#if>">
                    <a class="page-link" href="?page=${page}&sort=${sort}">${page + 1}</a>
                </li>
            </#list>

            <#if vacancies.hasNext()>
                <li class="page-item"><a class="page-link" href="?page=${vacancies.number + 1}&sort=${sort}"><@spring.message "vacancies.vacancies.next"/></a></li>
            <#else>
                <li class="page-item disabled"><a class="page-link" href="#"><@spring.message "vacancies.vacancies.next"/></a></li>
            </#if>
        </ul>
    </nav>

    <div class="row">
        <#list vacancies.content as vacancy>
            <div class="col-12 mb-4">
                <div class="d-flex align-items-center p-3 border rounded">
                    <div class="flex-shrink-0 me-3">
                        <a href="/vacancies/${vacancy.id}" class="btn btn-outline-info m-2"><@spring.message "vacancies.vacancies.title"/> : ${vacancy.name!""}</a>
                    </div>
                    <div class="flex-grow-1">
                        <p class="mb-1"><@spring.message "vacancies.vacancies.salary"/>: ${vacancy.salary!""}</p>
                        <p class="mb-1"><@spring.message "vacancies.vacancies.published_on"/>: ${vacancy.createdDate!""}</p>
                    </div>
                    <div class="flex-shrink-0 ms-3">
                        <a href="/profile/company/${vacancy.users.id}" class="btn btn-outline-info m-2"><@spring.message "vacancies.vacancies.check_company"/></a>
                    </div>
                </div>
            </div>
        </#list>
    </div>

    <script>
        document.addEventListener("DOMContentLoaded", function() {
            loadFilters();
        });

        function updateFilter() {
            const sortValue = document.getElementById('sort').value;
            localStorage.setItem('vacanciesSort', sortValue);

            document.getElementById('filterForm').submit();
        }

        function loadFilters() {
            const sortValue = localStorage.getItem('vacanciesSort');
            if (sortValue) {
                document.getElementById('sort').value = sortValue;
            }
        }
    </script>

</@main.layout>
