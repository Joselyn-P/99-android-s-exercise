package com.medical.a99houselistingapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.medical.a99houselistingapp.data.model.Address
import com.medical.a99houselistingapp.data.model.Attributes
import com.medical.a99houselistingapp.data.model.Listing

@Composable
fun ListingCard(
    listing: Listing,
    clickable: Boolean,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .then(
                if (clickable) Modifier
                    .clickable(onClick = onClick)
                else Modifier),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Column (modifier = Modifier
            .padding(16.dp)) {
                AsyncImage(
                    model = listing.photo,
                    contentDescription = listing.projectName,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop,
                    // so if the image not load, there's something there to tell that there's supposed to be an image
                    // used a file image cause it reaches the edges to help see
                    placeholder = painterResource(id = android.R.drawable.sym_contact_card)
                )

                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    modifier = Modifier
                        .padding(16.dp)) {
                    Text(
                        text = listing.projectName,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Column{
                        Text(
                            text = "${listing.address.streetName} · ${listing.address.district}",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Gray
                        )

                        Text(
                            text = "${listing.category} · ${listing.completedAt} · ${listing.tenure} yrs",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Gray
                        )
                    }

                    Text(
                        text = "${listing.attributes.bedrooms} Beds · ${listing.attributes.bathrooms} Baths · ${listing.attributes.areaSize} sqft",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .padding(vertical = 4.dp)
                    )

                    Text(
                        text = "$${listing.attributes.price}/mo",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListingCardPreview() {
    val sampleListing = Listing(
        address = Address(
            district = "D13",
            streetName = "12 Meyappa Chettiar Rd"
        ),
        attributes = Attributes(
            areaSize = 2561,
            bathrooms = 2,
            bedrooms = 3,
            price = 2561
        ),
        category = "Condo",
        completedAt = "2020",
        id = 0,
        photo = "https://picsum.photos/id/10/450/300",
        projectName = "Parkview Apartments",
        tenure = 99
    )

    MaterialTheme{
        ListingCard(
            listing = sampleListing,
            clickable = true,
            onClick = {}
        )
    }
}