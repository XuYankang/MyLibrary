package nlp.topicmodel;

import nlp.data.Dataset;

/**
 * Created by Administrator on 2014/7/16.
 */
public class FinalModel
{
    private Dataset dataset = null;

    // P(z|d): document-topic distribution
    private double[][] Pz_d = null;
    private int ntopics = -1;

    // P(w|z): topic-word distribution
    private double[][] Pw_z = null;

    // P(z|d,w): topic distribution for each word in each document
    private double[][][] Pz_dw = null;

    public FinalModel(Dataset dataset, int ntopics, double[][] Pz_d,
                      double[][] Pw_z, double[][][] Pz_dw)
    {
        this.dataset = dataset;
        this.ntopics = ntopics;
        this.Pz_d = Pz_d;
        this.Pw_z = Pw_z;
        this.Pz_dw = Pz_dw;
    }

    public Dataset getDataset()
    {
        return this.dataset;
    }

    public int getNumberofTopics()
    {
        return this.ntopics;
    }

    public double[][] getDocTopicDistribute()
    {
        return this.Pz_d;
    }
}