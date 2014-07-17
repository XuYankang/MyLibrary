package nlp.data;

import nlp.util.ErrorReport;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Data
{
    /**
     * Data identifier
     */
    private int id = -1;

    /**
     * features array
     */
    private ArrayList<Feature> features = null;

    /**
     * class label of this data
     */
    private int label = Integer.MIN_VALUE;

    /**
     * Total element number
     */
    private int size = -1;

    /**
     * Create a Data object from string data line. The data line is in svmlight
     * and libsvm format but with feature index starts from 0. For example:
     * "-1 0:0.43 1:0.12 9284:0.2". please be care that the index here starts
     * from 0 rather than 1 which used in svmlight and libsvm, and no comment
     * part is included.
     *
     * @param initID
     *            the data id
     * @param line
     *            the data line in svmlight and libsvm format with feature index
     *            starts from 0
     */
    public Data(int initID, String line)
    {
        this.id = initID;
        this.features = readData(line);
        this.size = this.features.size();
    }

    private ArrayList<Feature> readData(String line)
    {
        StringTokenizer stk = new StringTokenizer(line);

        try
        {
            // get label
            this.label = Integer.parseInt(stk.nextToken());

            // get features
            ArrayList<Feature> fs = new ArrayList<Feature>();
            while (stk.hasMoreTokens())
            {
                String pair[] = stk.nextToken().split(":");
                int dim = Integer.parseInt(pair[0]);
                double value = Double.parseDouble(pair[1]);

                fs.add(new Feature(dim, value));
            }

            return fs;
        }
        catch (NumberFormatException nfe)
        {
            ErrorReport.showMessage(this, "readData");
            return null;
        }
    }

    public int getID()
    {
        return this.id;
    }

    /**
     * Get the feature at the specified position.
     *
     * @param position
     * @return the feature at the specified position.
     */
    public Feature getFeatureAt(int position)
    {
        return features.get(position);
    }

    public int getLabel()
    {
        return this.label;
    }

    public ArrayList<Feature> getAllFeature()
    {
        return features;
    }

    public int size()
    {
        return this.size;
    }
}