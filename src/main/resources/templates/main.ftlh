<#import "layout.ftlh" as main>

<@main.layout ; spring>


    <h2><@spring.message "main.hello"/></h2>

    <div class="row backpost">

        <div class="col col-12 col-md-6 colpost"> <img src="../static/images/photo.jpg" class="w-100" alt="flats">
        </div>

        <div class="col col-12 col-md-6 colpost">

            <p class="mt-3"><strong class="poststrong"><@spring.message "main.create_an_account_and_then_open_new_resume_for_different_opportunity"/></strong></p>

            <p class="postp-2"><@spring.message "main.make_a_business_it_is_easy_open_new_vacancy_for_our_company_and_start_grow_with_us_together_!"/></p>

        </div>

    </div>

    <div class="row mt-5 g-0">

        <div class="col col-12  col-md-12 col-lg-6 ">

            <div class="card rounded-0 yellowleft h-100">
                <h4 class="mt-5 ms-5"><@spring.message "main.it_started_out_as_a_simple_idea_and_evolved_into_our_passion"/></h4>

                <p class="yellowp mt-4 ms-5"><@spring.message "main.open_your_heart_to_work_with_different_people_from_around_world_and_make_a_new_friends_and_grow_your_connections_it_is_not_hard_to_do_it_just_be_confident_and_smile_it_is_sunnah_and_work_hard_!"/></p>

            </div>

        </div>

        <div class="col col-12 col-md-12 col-lg-6">
            <div class="card rounded-0 h-100">
                <img src="../static/images/photo-group.jpg" alt="group">
            </div>
        </div>

    </div>


</@main.layout>