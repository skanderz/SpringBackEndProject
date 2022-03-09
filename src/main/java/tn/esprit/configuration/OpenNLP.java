package tn.esprit.configuration;


import java.util.Properties;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;
import tn.esprit.spring.entity.Priority;

public class OpenNLP {
 


    public Priority findSentiment(String line) {



        Properties props = new Properties();

        props.setProperty("annotators", "tokenize, ssplit, parse, sentiment");

        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

        int mainSentiment = 0;

        if (line != null && line.length() > 0) {

            int longest = 0;

            Annotation annotation = pipeline.process(line);

            for (CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class)) {

                Tree tree = sentence.get(SentimentCoreAnnotations.SentimentAnnotatedTree.class);

                int sentiment = RNNCoreAnnotations.getPredictedClass(tree);

                String partText = sentence.toString();

                if (partText.length() > longest) {

                    mainSentiment = sentiment;

                    longest = partText.length();

                }



            }

        }

        //0 or 1 it means very negative
        if(mainSentiment==0 || mainSentiment==1){
            return Priority.high;
        }else if(mainSentiment==3||mainSentiment==4){//3 or 4 means very positive
            return Priority.normal;
        }else {//2 that means neutral don't pay a lot of attention to him
            return Priority.low;
        }






    }


}
