package br.com.ecommerce;

import com.knuddels.jtokkit.Encodings;
import com.knuddels.jtokkit.api.ModelType;

public class ContadorDeToken {
    public static void main(String[] args) {
        var registry = Encodings.newDefaultEncodingRegistry();
        var enc = registry.getEncodingForModel(ModelType.GPT_4);
        var qnt = enc.countTokens("Identifique a quantidade de tokens");
        System.out.println("QNT de tokens: " + qnt);



    }
}
