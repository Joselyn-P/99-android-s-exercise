# 99 House Listing App

## Tech Stack

- **Kotlin**
- **Jetpack Compose** — UI
- **Navigation Compose** — screen navigation (`search` to `detail/{id}` and back)
- **Retrofit + Moshi** — networking and JSON parsing
- **Coil** — async laoding image 
- **ViewModel + StateFlow** — MVVM state management 

## Prerequisites

- Android Studio (min. Koala)
- JDK 17
- Android SDK with a minimum SDK of API 24 (Android 7.0 / Nougat)
- Internet connection

## Project Structure

```
app/src/main/java/com/medical/a99houselistingapp/
├── data/
│   ├── model/ (Listing, ListingDetail, shared ListingCommon interface)
│   ├── remote/ (ApiService, RetrofitInstance)
│   └── repository/ (ListingRepository)
├── ui/
│   ├── components/ (ListingCard)
│   ├── search/ (SearchResultScreen)
│   └── detail/ (ListingDetailScreen)
├── viewmodel/ (SearchResultViewModel, ListingDetailViewModel)
└── MainActivity.kt (NavHost setup)
```

## Known Limitations
- the backend only has unique data for listings IDs: 0, 1, 2. Request for a deatil page outsude this range will result in "unavailable" state.
- the backend data for detail feeds in Listing Details for listings IDs: 1, 2 is a duplication from listings: 0 (except for photo).