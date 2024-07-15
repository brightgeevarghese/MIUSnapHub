package edu.miu.listdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.miu.listdemo.data.Datasource
import edu.miu.listdemo.model.Quote
import edu.miu.listdemo.ui.theme.ListDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    QuotesApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun QuotesApp(modifier: Modifier = Modifier) {
    QuoteList(modifier = modifier)
}
@Composable
fun QuoteCard(quote: Quote, modifier: Modifier   = Modifier) {
    Card(modifier = modifier) {
        Column {
            Image(
                painter = painterResource(id = quote.imageResourceId),
                contentDescription = stringResource(id = quote.stringResourceID),
                modifier = Modifier.fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(id = quote.stringResourceID),
                fontSize = 20.sp,
            )
        }
    }
}

@Composable
fun QuoteList(modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(Datasource().loadQuotes()) { quote ->
            QuoteCard(
                quote = quote,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    ListDemoTheme {
        QuoteList()
    }
}