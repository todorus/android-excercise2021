package com.todorus.logic

import com.todorus.domain.*
import com.todorus.logic.api.ProductService
import org.junit.Assert.assertEquals
import org.junit.Test

class SerializationTest {

    @Test
    fun `Gson should parse Products correctly`() {
        // Given I have a JSON text
        // And it contains a Product
        val data = productData

        // When I run it through the parser
        val result = gson.fromJson(data, ProductService.Result::class.java)

        // Then it should return the Product
        val expected = ProductService.Result(
            listOf(
                Product(
                    id = "9200000028828094",
                    ean = "0885370863987",
                    title = "Halo - The Master Chief Collection - Xbox One",
                    rating = 48,
                    shortDescription = "Inhoud HALO - The Master Chief Collection Halo: Combat Evolved Anniversary Geremasterde Halo 2: Anniversary Halo 3 Halo 4 Nieuwe digitale series: Halo: Nightfall Toegang tot Halo 5: Guardians Beta. De ultieme Halo ervaring! Geoptimiseerd voor Xbox Series X beschikt over Smart Delivery en speelt af in 4K Ultra HD met 60 frames per seconde. Speelt op Xbox Series S, Xbox Series X en Xbox One. Het complete Master Chief-verhaal Het complete verhaal over deze iconische held en zijn epische reis wordt nu uitgebracht als The Master Chief Collection. Halo: Combat Evolved Anniversary, Halo 2: Anniversary, Halo 3, en Halo 4 zijn uitgevoerd met de 60fps beeldkwaliteit van de Xbox One, en bevatten in totaal 45 campagnemissies en meer dan 100 multiplayer (inclusief de originele Halo Combat Evolved-kaarten) en Spartan Ops-kaarten. Samen met de nieuwe proloog- en epiloogscènes als voorbode op Halo 5: Guardians, is dit de collectie voor de Xbox One waarop Halo-fans hebben gewacht. Halo 2: Anniversary De iconische held is na 10 jaar terug. Met een volledig geremasterde campagne met ‘Classic Mode’ waarmee je onmiddellijk kunt switchentussen de geremasterde versie en de originele game uit 2004. Ontdek de nieuwe Halo 5: Guardians-verhaalelementen in verborgen terminal-video’s en gebruik alle nieuwe skulls om de campagne op een hele nieuwe manier te ervaren. Ook alle 23 originele multiplayer-kaarten zitten erbij, naast 6 volledig opnieuw uitgevoerde kaarten. Speel het spel dat een hele nieuwe dimensie gaf aan multiplayer-games opconsoles, en bereid je voor op het volgende Halo-hoofdstuk. Master Menu Navigeer moeiteloos door het verhaal van The Master Chief met het volledig nieuwe Master Menu. Speel alle vier de volledig gedeblokkeerde campagnes van het begin tot het eind of duik middenin de actie. De game-ontwerpers voegden hun eigen playlists van campagnes toe voor nieuwe, spannende uitdagingen. Vind en speel moeiteloos je favoriete multiplayer-games uit meer dan 100 multiplayer en Spartan Ops-kaarten. Dat is alles wat er in Halo, op jouw voorwaarden, vereenvoudigd werd. New Halo: Nightfall Live Action Digital Series Een vreemde, vijandige wereld waarin UNSC-topagenten aan een nog groter gevaar worden blootgesteld in deze live actieserie van 343 Industries en Scott Free Productions. Met Ridley Scott en de directeur van Scott Free TV, David Zucker, als uitvoerend producenten en geregisseerd door Sergio Mimica-Gezzan (“Battlestar Galactica”, “Pillars of the Earth”, “Heroes”), is Halo: Nightfall een spannend nieuw verhaal voor oude én nieuwe Halo-fans. Halo 5: Guardians Multiplayer Beta Wees één van de eersten die de nieuwe generatie Halo-multiplayer speelt in Halo 5: Guardians Beta. Bereid je voor op de Guardians beta door de exclusieve content in The Master Chief Collection en Halo: Nightfall vrij te spelen. Deze exclusieve items neem je mee naar Halo 5: Guardians.",
                    longDescription = "<strong>Inhoud HALO - The Master Chief Collection</strong><br />\n<ul>\n<li>Halo: Combat Evolved Anniversary</li>\n<li>Geremasterde Halo 2: Anniversary</li>\n<li>Halo 3 </li>\n<li>Halo 4</li>\n<li>Nieuwe digitale series: Halo: Nightfall</li>\n<li>Toegang tot Halo 5: Guardians Beta. De ultieme Halo ervaring!</li>\n</ul>\n<strong>Geoptimiseerd voor Xbox Series X</strong><br />beschikt over Smart Delivery en speelt af in 4K Ultra HD met 60 frames per seconde. Speelt op Xbox Series S, Xbox Series X en Xbox One.<br /><br /><strong>Het complete Master Chief-verhaal</strong><br />Het complete verhaal over deze iconische held en zijn epische reis wordt nu uitgebracht als The Master Chief Collection. Halo: Combat Evolved Anniversary, Halo 2: Anniversary, Halo 3, en Halo 4 zijn uitgevoerd met de 60fps beeldkwaliteit van de Xbox One, en bevatten in totaal 45 campagnemissies en meer dan 100 multiplayer (inclusief de originele Halo Combat Evolved-kaarten) en Spartan Ops-kaarten. Samen met de nieuwe proloog- en epiloogscènes als voorbode op Halo 5: Guardians, is dit de collectie voor de Xbox One waarop Halo-fans hebben gewacht.<br /><br /><strong>Halo 2: Anniversary</strong><br />De iconische held is na 10 jaar terug. Met een volledig geremasterde campagne met ‘Classic Mode’ waarmee je onmiddellijk kunt switchentussen de geremasterde versie en de originele game uit 2004. Ontdek de nieuwe Halo 5: Guardians-verhaalelementen in verborgen terminal-video’s en gebruik alle nieuwe skulls om de campagne op een hele nieuwe manier te ervaren. Ook alle 23 originele multiplayer-kaarten zitten erbij, naast 6 volledig opnieuw uitgevoerde kaarten. Speel het spel dat een hele nieuwe dimensie gaf aan multiplayer-games opconsoles, en bereid je voor op het volgende Halo-hoofdstuk.<br /><br /><strong>Master Menu</strong><br />Navigeer moeiteloos door het verhaal van The Master Chief met het volledig nieuwe Master Menu. Speel alle vier de volledig gedeblokkeerde campagnes van het begin tot het eind of duik middenin de actie. De game-ontwerpers voegden hun eigen playlists van campagnes toe voor nieuwe, spannende uitdagingen. Vind en speel moeiteloos je favoriete multiplayer-games uit meer dan 100 multiplayer en Spartan Ops-kaarten. Dat is alles wat er in Halo, op jouw voorwaarden, vereenvoudigd werd.<br /><br /><strong>New Halo: Nightfall Live Action Digital Series</strong><br />Een vreemde, vijandige wereld waarin UNSC-topagenten aan een nog groter gevaar worden blootgesteld in deze live actieserie van 343 Industries en Scott Free Productions. Met Ridley Scott en de directeur van Scott Free TV, David Zucker, als uitvoerend producenten en geregisseerd door Sergio Mimica-Gezzan (“Battlestar Galactica”, “Pillars of the Earth”, “Heroes”), is Halo: Nightfall een spannend nieuw verhaal voor oude én nieuwe Halo-fans.<br /><br /><strong>Halo 5: Guardians Multiplayer Beta</strong><br />Wees één van de eersten die de nieuwe generatie Halo-multiplayer speelt in Halo 5: Guardians Beta. Bereid je voor op de Guardians beta door de exclusieve content in The Master Chief Collection en Halo: Nightfall vrij te spelen. Deze exclusieve items neem je mee naar Halo 5: Guardians.",
                    attributeGroups = listOf(
                        AttributeGroup(
                            title = "Productinformatie",
                            attributes = listOf(
                                Attribute(
                                    label = "Merk",
                                    value = "Microsoft"
                                ),
                                Attribute(
                                    key = "PLATFORM",
                                    label = "Platform",
                                    value = "Xbox One"
                                ),
                                Attribute(
                                    label = "Genre",
                                    value = "Actie"
                                )
                            )
                        ),
                        AttributeGroup(
                            title = "Doelgroep",
                            attributes = listOf(
                                Attribute(
                                    key = "TARGET_AUDIENCE",
                                    label = "Doelgroep",
                                    value = "Fanatieke gamer"
                                ),
                                Attribute(
                                    label = "Minimale leeftijd",
                                    value = "18"
                                ),
                                Attribute(
                                    label = "Inhoud leeftijdsindicatie",
                                    value = "Geweld | Grof taalgebruik"
                                )
                            )
                        )
                    ),
                    images = listOf(
                        Attribute(
                            type = "IMAGE",
                            key = "XS",
                            url = "https://media.s-bol.com/K83QQkwjyy1n/47x60.jpg"
                        ),
                        Attribute(
                            type = "IMAGE",
                            key = "S",
                            url = "https://media.s-bol.com/K83QQkwjyy1n/97x123.jpg"
                        )
                    ),
                    offerData = OfferData(
                        bolCom = 0,
                        nonProfessionalSellers = 1,
                        professionalSellers = 0,
                        offers = listOf(
                            Offer(
                                id = "1001034641790806",
                                condition = "Als nieuw",
                                price = 43.49f
                            )
                        )
                    )
                )
            )
        )

        assertEquals(expected, result)
    }

    private val productData = "{\n" +
            "    \"products\": [\n" +
            "        {\n" +
            "            \"id\": \"9200000028828094\",\n" +
            "            \"ean\": \"0885370863987\",\n" +
            "            \"gpc\": \"EGAME\",\n" +
            "            \"title\": \"Halo - The Master Chief Collection - Xbox One\",\n" +
            "            \"specsTag\": \"Microsoft\",\n" +
            "            \"rating\": 48,\n" +
            "            \"shortDescription\": \"Inhoud HALO - The Master Chief Collection Halo: Combat Evolved Anniversary Geremasterde Halo 2: Anniversary Halo 3 Halo 4 Nieuwe digitale series: Halo: Nightfall Toegang tot Halo 5: Guardians Beta. De ultieme Halo ervaring! Geoptimiseerd voor Xbox Series X beschikt over Smart Delivery en speelt af in 4K Ultra HD met 60 frames per seconde. Speelt op Xbox Series S, Xbox Series X en Xbox One. Het complete Master Chief-verhaal Het complete verhaal over deze iconische held en zijn epische reis wordt nu uitgebracht als The Master Chief Collection. Halo: Combat Evolved Anniversary, Halo 2: Anniversary, Halo 3, en Halo 4 zijn uitgevoerd met de 60fps beeldkwaliteit van de Xbox One, en bevatten in totaal 45 campagnemissies en meer dan 100 multiplayer (inclusief de originele Halo Combat Evolved-kaarten) en Spartan Ops-kaarten. Samen met de nieuwe proloog- en epiloogscènes als voorbode op Halo 5: Guardians, is dit de collectie voor de Xbox One waarop Halo-fans hebben gewacht. Halo 2: Anniversary De iconische held is na 10 jaar terug. Met een volledig geremasterde campagne met ‘Classic Mode’ waarmee je onmiddellijk kunt switchentussen de geremasterde versie en de originele game uit 2004. Ontdek de nieuwe Halo 5: Guardians-verhaalelementen in verborgen terminal-video’s en gebruik alle nieuwe skulls om de campagne op een hele nieuwe manier te ervaren. Ook alle 23 originele multiplayer-kaarten zitten erbij, naast 6 volledig opnieuw uitgevoerde kaarten. Speel het spel dat een hele nieuwe dimensie gaf aan multiplayer-games opconsoles, en bereid je voor op het volgende Halo-hoofdstuk. Master Menu Navigeer moeiteloos door het verhaal van The Master Chief met het volledig nieuwe Master Menu. Speel alle vier de volledig gedeblokkeerde campagnes van het begin tot het eind of duik middenin de actie. De game-ontwerpers voegden hun eigen playlists van campagnes toe voor nieuwe, spannende uitdagingen. Vind en speel moeiteloos je favoriete multiplayer-games uit meer dan 100 multiplayer en Spartan Ops-kaarten. Dat is alles wat er in Halo, op jouw voorwaarden, vereenvoudigd werd. New Halo: Nightfall Live Action Digital Series Een vreemde, vijandige wereld waarin UNSC-topagenten aan een nog groter gevaar worden blootgesteld in deze live actieserie van 343 Industries en Scott Free Productions. Met Ridley Scott en de directeur van Scott Free TV, David Zucker, als uitvoerend producenten en geregisseerd door Sergio Mimica-Gezzan (“Battlestar Galactica”, “Pillars of the Earth”, “Heroes”), is Halo: Nightfall een spannend nieuw verhaal voor oude én nieuwe Halo-fans. Halo 5: Guardians Multiplayer Beta Wees één van de eersten die de nieuwe generatie Halo-multiplayer speelt in Halo 5: Guardians Beta. Bereid je voor op de Guardians beta door de exclusieve content in The Master Chief Collection en Halo: Nightfall vrij te spelen. Deze exclusieve items neem je mee naar Halo 5: Guardians.\",\n" +
            "            \"longDescription\": \"<strong>Inhoud HALO - The Master Chief Collection</strong><br />\n<ul>\n<li>Halo: Combat Evolved Anniversary</li>\n<li>Geremasterde Halo 2: Anniversary</li>\n<li>Halo 3 </li>\n<li>Halo 4</li>\n<li>Nieuwe digitale series: Halo: Nightfall</li>\n<li>Toegang tot Halo 5: Guardians Beta. De ultieme Halo ervaring!</li>\n</ul>\n<strong>Geoptimiseerd voor Xbox Series X</strong><br />beschikt over Smart Delivery en speelt af in 4K Ultra HD met 60 frames per seconde. Speelt op Xbox Series S, Xbox Series X en Xbox One.<br /><br /><strong>Het complete Master Chief-verhaal</strong><br />Het complete verhaal over deze iconische held en zijn epische reis wordt nu uitgebracht als The Master Chief Collection. Halo: Combat Evolved Anniversary, Halo 2: Anniversary, Halo 3, en Halo 4 zijn uitgevoerd met de 60fps beeldkwaliteit van de Xbox One, en bevatten in totaal 45 campagnemissies en meer dan 100 multiplayer (inclusief de originele Halo Combat Evolved-kaarten) en Spartan Ops-kaarten. Samen met de nieuwe proloog- en epiloogscènes als voorbode op Halo 5: Guardians, is dit de collectie voor de Xbox One waarop Halo-fans hebben gewacht.<br /><br /><strong>Halo 2: Anniversary</strong><br />De iconische held is na 10 jaar terug. Met een volledig geremasterde campagne met ‘Classic Mode’ waarmee je onmiddellijk kunt switchentussen de geremasterde versie en de originele game uit 2004. Ontdek de nieuwe Halo 5: Guardians-verhaalelementen in verborgen terminal-video’s en gebruik alle nieuwe skulls om de campagne op een hele nieuwe manier te ervaren. Ook alle 23 originele multiplayer-kaarten zitten erbij, naast 6 volledig opnieuw uitgevoerde kaarten. Speel het spel dat een hele nieuwe dimensie gaf aan multiplayer-games opconsoles, en bereid je voor op het volgende Halo-hoofdstuk.<br /><br /><strong>Master Menu</strong><br />Navigeer moeiteloos door het verhaal van The Master Chief met het volledig nieuwe Master Menu. Speel alle vier de volledig gedeblokkeerde campagnes van het begin tot het eind of duik middenin de actie. De game-ontwerpers voegden hun eigen playlists van campagnes toe voor nieuwe, spannende uitdagingen. Vind en speel moeiteloos je favoriete multiplayer-games uit meer dan 100 multiplayer en Spartan Ops-kaarten. Dat is alles wat er in Halo, op jouw voorwaarden, vereenvoudigd werd.<br /><br /><strong>New Halo: Nightfall Live Action Digital Series</strong><br />Een vreemde, vijandige wereld waarin UNSC-topagenten aan een nog groter gevaar worden blootgesteld in deze live actieserie van 343 Industries en Scott Free Productions. Met Ridley Scott en de directeur van Scott Free TV, David Zucker, als uitvoerend producenten en geregisseerd door Sergio Mimica-Gezzan (“Battlestar Galactica”, “Pillars of the Earth”, “Heroes”), is Halo: Nightfall een spannend nieuw verhaal voor oude én nieuwe Halo-fans.<br /><br /><strong>Halo 5: Guardians Multiplayer Beta</strong><br />Wees één van de eersten die de nieuwe generatie Halo-multiplayer speelt in Halo 5: Guardians Beta. Bereid je voor op de Guardians beta door de exclusieve content in The Master Chief Collection en Halo: Nightfall vrij te spelen. Deze exclusieve items neem je mee naar Halo 5: Guardians.\",\n" +
            "            \"attributeGroups\": [\n" +
            "                {\n" +
            "                    \"title\": \"Productinformatie\",\n" +
            "                    \"attributes\": [\n" +
            "                        {\n" +
            "                            \"label\": \"Merk\",\n" +
            "                            \"value\": \"Microsoft\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"key\": \"PLATFORM\",\n" +
            "                            \"label\": \"Platform\",\n" +
            "                            \"value\": \"Xbox One\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"label\": \"Genre\",\n" +
            "                            \"value\": \"Actie\"\n" +
            "                        }\n" +
            "                    ]\n" +
            "                },\n" +
            "                {\n" +
            "                    \"title\": \"Doelgroep\",\n" +
            "                    \"attributes\": [\n" +
            "                        {\n" +
            "                            \"key\": \"TARGET_AUDIENCE\",\n" +
            "                            \"label\": \"Doelgroep\",\n" +
            "                            \"value\": \"Fanatieke gamer\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"label\": \"Minimale leeftijd\",\n" +
            "                            \"value\": \"18\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"label\": \"Inhoud leeftijdsindicatie\",\n" +
            "                            \"value\": \"Geweld | Grof taalgebruik\"\n" +
            "                        }\n" +
            "                    ]\n" +
            "                }\n" +
            "            ],\n" +
            "            \"entityGroups\": [\n" +
            "                {\n" +
            "                    \"title\": \"Acteurs\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"title\": \"Artiesten\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"title\": \"Auteurs\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"title\": \"Regisseur\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"title\": \"Regisseur\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"title\": \"Uitgever\",\n" +
            "                    \"entities\": [\n" +
            "                        {\n" +
            "                            \"id\": \"1551048\",\n" +
            "                            \"value\": \"Microsoft\"\n" +
            "                        }\n" +
            "                    ]\n" +
            "                }\n" +
            "            ],\n" +
            "            \"urls\": [\n" +
            "                {\n" +
            "                    \"key\": \"DESKTOP\",\n" +
            "                    \"value\": \"https://www.bol.com/nl/p/halo-the-master-chief-collection-xbox-one/9200000028828094\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"key\": \"MOBILE\",\n" +
            "                    \"value\": \"https://www.bol.com/nl/p/halo-the-master-chief-collection-xbox-one/9200000028828094\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"images\": [\n" +
            "                {\n" +
            "                    \"type\": \"IMAGE\",\n" +
            "                    \"key\": \"XS\",\n" +
            "                    \"url\": \"https://media.s-bol.com/K83QQkwjyy1n/47x60.jpg\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"type\": \"IMAGE\",\n" +
            "                    \"key\": \"S\",\n" +
            "                    \"url\": \"https://media.s-bol.com/K83QQkwjyy1n/97x123.jpg\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"media\": [\n" +
            "                {\n" +
            "                    \"type\": \"IMAGE\",\n" +
            "                    \"key\": \"XL\",\n" +
            "                    \"url\": \"https://media.s-bol.com/BxGk3GYvVjY/550x237.jpg\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"type\": \"IMAGE\",\n" +
            "                    \"key\": \"XL\",\n" +
            "                    \"url\": \"https://media.s-bol.com/K83QQkwjyy1n/550x695.jpg\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"type\": \"IMAGE\",\n" +
            "                    \"key\": \"XL\",\n" +
            "                    \"url\": \"https://media.s-bol.com/N9Xl9L5kZl68/550x385.jpg\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"type\": \"IMAGE\",\n" +
            "                    \"key\": \"XL\",\n" +
            "                    \"url\": \"https://media.s-bol.com/OyLmyM5Y1m0E/550x309.jpg\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"type\": \"IMAGE\",\n" +
            "                    \"key\": \"XL\",\n" +
            "                    \"url\": \"https://media.s-bol.com/RRy5jPq83DL/550x309.jpg\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"type\": \"IMAGE\",\n" +
            "                    \"key\": \"XL\",\n" +
            "                    \"url\": \"https://media.s-bol.com/grWlm88JLG3/550x309.jpg\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"type\": \"IMAGE\",\n" +
            "                    \"key\": \"XL\",\n" +
            "                    \"url\": \"https://media.s-bol.com/myD813VJPWyR/550x706.jpg\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"type\": \"IMAGE\",\n" +
            "                    \"key\": \"XL\",\n" +
            "                    \"url\": \"https://media.s-bol.com/qGWyzGvE6lG/550x309.jpg\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"type\": \"IMAGE\",\n" +
            "                    \"key\": \"XL\",\n" +
            "                    \"url\": \"https://media.s-bol.com/xPWJJD4Lp4J/550x309.jpg\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"type\": \"IMAGE\",\n" +
            "                    \"key\": \"XL\",\n" +
            "                    \"url\": \"https://media.s-bol.com/xkqq9kQqrq7E/550x209.jpg\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"offerData\": {\n" +
            "                \"bolCom\": 0,\n" +
            "                \"nonProfessionalSellers\": 1,\n" +
            "                \"professionalSellers\": 0,\n" +
            "                \"offers\": [\n" +
            "                    {\n" +
            "                        \"id\": \"1001034641790806\",\n" +
            "                        \"condition\": \"Als nieuw\",\n" +
            "                        \"price\": 43.49,\n" +
            "                        \"availabilityCode\": \"-1\",\n" +
            "                        \"availabilityDescription\": \"Uiterlijk 22 april in huis\",\n" +
            "                        \"comment\": \"2 Maanden garantie! Tweedehands met de service van nieuw. Al onze games worden gecontroleerd op krassen. Wij versturen 100% werkende games en bieden 2 maanden garantie. Standaard geleverd in het originele doosje met bijbehorende boekjes. In enkele gevallen komt het voor dat de game geen boekje bevat.\",\n" +
            "                        \"seller\": {\n" +
            "                            \"id\": \"1226406\",\n" +
            "                            \"sellerType\": \"Kleinzakelijke verkoper\",\n" +
            "                            \"displayName\": \"GooHoo Gameshops B.V.\",\n" +
            "                            \"topSeller\": false,\n" +
            "                            \"logo\": \"https://s-test2.s-bol.com/nl/cms/images/sellerlogos/sellerlogo_1226406.png\",\n" +
            "                            \"sellerRating\": {\n" +
            "                                \"ratingMethod\": \"THREE_MONTHS\",\n" +
            "                                \"sellerRating\": \"8.8\",\n" +
            "                                \"productInformationRating\": \"9.1\",\n" +
            "                                \"deliveryTimeRating\": \"9.0\",\n" +
            "                                \"shippingRating\": \"8.8\",\n" +
            "                                \"serviceRating\": \"-\"\n" +
            "                            },\n" +
            "                            \"recentReviewCounts\": {\n" +
            "                                \"positiveReviewCount\": 31,\n" +
            "                                \"neutralReviewCount\": 3,\n" +
            "                                \"negativeReviewCount\": 2,\n" +
            "                                \"totalReviewCount\": 36\n" +
            "                            },\n" +
            "                            \"sellerInformation\": \"Bij GooHoo geven we producten een tweede en duurzame toekomst. Wij kopen, testen en verkopen via professionele en gespecialiseerde webwinkels een breed scala aan gebruikte artikelen. Hierdoor kunnen onze klanten genieten van goedkope en exclusieve producten met de service en garantie zoals ze die gewend zijn bij het online winkelen. Wij dragen zorg voor een snelle levering en uitgebreide garantie, ook op gebruikte producten! Zo leveren wij dus de garantie waar je op rekent, de service die je verwacht én verassen we je met onze prijzen en milieubewuste aanpak.\",\n" +
            "                            \"useWarrantyRepairConditions\": false,\n" +
            "                            \"approvalPercentage\": \"93.9\",\n" +
            "                            \"registrationDate\": \"2016-09-28T02:00:00.000+02:00\"\n" +
            "                        },\n" +
            "                        \"bestOffer\": true\n" +
            "                    }\n" +
            "                ]\n" +
            "            },\n" +
            "            \"parentCategoryPaths\": [\n" +
            "                {\n" +
            "                    \"parentCategories\": [\n" +
            "                        {\n" +
            "                            \"id\": \"3135\",\n" +
            "                            \"name\": \"Games\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"id\": \"18200\",\n" +
            "                            \"name\": \"Videogames\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"id\": \"38905\",\n" +
            "                            \"name\": \"Xbox One-games\"\n" +
            "                        }\n" +
            "                    ]\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    ]\n" +
            "}"

}