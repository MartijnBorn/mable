# Welkom bij mijn assessment opdracht

## How to run
Ik heb gebruik gemaakt van docker-compose voor het opzetten van een lokale database. 
Deze database kan opgestart worden door middel van het commando:
`docker-compose up`

Dit start alleen de database op. De java applicatie kan opgestart worden in de map "mable_assessment_martijn" met het volgende commando:
`mvn spring-boot:run` 
Dit vereist de database runnende om te functioneren.
Dit initializeert automatisch de database.

## API doc
Ik heb in de bijlage een POSTMAN export geplaatst met de API calls.
Endpoints zijn article,category,favorite en list.

## Extra requirements
Voor de extra requirements heb ik de volgende gekozen:
1. Groepeer artikelen per categorie. (Verwerkt in GET localhost:8080/category)
2. Maak het mogelijk om artikelen favoriet te maken. (Voorzien van eigen endpoint /favorite en eigen database tabel)
3. Maak het mogelijk om boodschappenlijsten te maken. (Voorzien van eigen endpoint /list en eigen database tabellen)

## Opmerkingen
- Ik heb deze opdracht gemaakt in ongeveer 5 uur.
- Er zijn geen unit tests present. Dit is met opzet en omdat er geen algoritmes present zijn, het gaat hier enkel om het aanroepen van bestaande spring/jpa functionaliteiten waardoor er niks te testen valt. 
- Ik kon geen "Easy Fix" manier bedenken om JSON to corrigeren in mijn code dus ik heb een placeholder oplossing door categories vanuit een gecorrigeerd bestand in te lezen. 
- Succes met het nakijken en ik hoor graag snel van jullie terug!