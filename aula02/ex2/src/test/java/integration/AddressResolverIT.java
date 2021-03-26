package integration;

import connection.TqsBasicHttpClient;
import geocoding.Address;
import geocoding.AddressResolver;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AddressResolverIT {


    @BeforeEach
    public void init(){
    }

    @Test
    public void whenGoodCoordidates_returnAddress() throws IOException, URISyntaxException, ParseException {
        TqsBasicHttpClient client = new TqsBasicHttpClient();
        AddressResolver resolver = new AddressResolver(client);

        Address result = resolver.findAddressForLocation(40.640661, -8.656688);
        assertEquals( result, new Address( "Cais do Alboi", "Glória e Vera Cruz", "Centro", "3800-246", null) );
    }

    @Test
    public void whenBadCoordidates_trhowBadArrayindex() throws IOException, URISyntaxException, ParseException {
        TqsBasicHttpClient client = new TqsBasicHttpClient();
        AddressResolver resolver = new AddressResolver(client);

        assertThrows(IndexOutOfBoundsException.class, () -> resolver.findAddressForLocation(100, 100));
    }

}
