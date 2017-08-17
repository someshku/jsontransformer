package com.json.transformer.demo;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.JsonUtils;

public class LambdaFunctionHandler implements RequestHandler<Object, Object> {

    @Override
    public Object handleRequest(Object input, Context context) {
        context.getLogger().log("Input: " + input);
        
        List chainrSpecJSON = JsonUtils.classpathToList( "/awsiotbutton.json" );
        Chainr chainr = Chainr.fromSpec( chainrSpecJSON );

        //Object inputJSON = JsonUtils.jsonToObject(input.toString()); //( "/input/awsiotbutton.json" );
        Object transformedOutput = chainr.transform( input );
        
        
        //String jsonResponse = JsonUtils.toJsonString( transformedOutput );
        

        return transformedOutput;
    }

}
