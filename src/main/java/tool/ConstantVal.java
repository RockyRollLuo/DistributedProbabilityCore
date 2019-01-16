package tool;

import java.util.HashMap;
import java.util.Map;

public class ConstantVal {

    /**
     * algorithm type
     */
    public static final int AlgorithmType_DistributedSimpleCoreDecomposition = 0;
    public static final int AlgorithmType_DistributedCoreDecomposition = 1;
    public static final int AlgorithmType_DistributedEtaCoreDecomposition = 2;
    public static final int AlgorithmType_PeelCoreDecomposition = 3;
    public static final int AlgorithmType_EtaCoreDecomposition = 4;

    public final static Map<Integer, String> MapAlgorithmType = new HashMap<Integer, String>();
    static {
        MapAlgorithmType.put(0, "Distributed Simple Core Decomposition");
        MapAlgorithmType.put(1, "Distributed Core Decomposition");
        MapAlgorithmType.put(2, "Distributed Eta Core Decomposition");
        MapAlgorithmType.put(3, "Peel Core Decomposition");
        MapAlgorithmType.put(4, "Eta Core Decomposition");
    }

    /**
     * undirect graph
     **/
    public final static Map<Integer, String> MapDatasetName_UndirectGraph = new HashMap<Integer, String>();
    static {
        MapDatasetName_UndirectGraph.put(0, "p2p-Gnutella08.txt       # MinIndex:0    MaxIndex:6300       Nodes: 6301     Edges: 20777");
        MapDatasetName_UndirectGraph.put(1, "p2p-Gnutella09.txt       # MinIndex:0    MaxIndex:8113       Nodes: 8114     Edges: 26013");
        MapDatasetName_UndirectGraph.put(2, "CA-GrQc.txt              # MinIndex:13   MaxIndex:26196      Nodes: 5242     Edges: 28980");
        MapDatasetName_UndirectGraph.put(3, "Email-Enron.txt          # MinIndex:0    MaxIndex:36691      Nodes: 36692    Edges: 367662");
        MapDatasetName_UndirectGraph.put(4, "p2p-Gnutella31.txt       # MinIndex:0    MaxIndex:62585      Nodes: 62586    Edges: 147892");
        MapDatasetName_UndirectGraph.put(5, "CA-CondMat.txt           # MinIndex:1    MaxIndex:108299     Nodes: 23133    Edges: 186936");
        MapDatasetName_UndirectGraph.put(6, "CA-AstroPh.txt           # MinIndex:3    MaxIndex:133279     Nodes: 18772    Edges: 396160");
        MapDatasetName_UndirectGraph.put(7, "com-dblp.ungraph.txt     # MinIndex:0    MaxIndex:425956     Nodes: 317080   Edges: 1049866");
        MapDatasetName_UndirectGraph.put(8, "roadNet-TX.txt           # MinIndex:0    MaxIndex:1393382    Nodes: 1379917  Edges: 3843320");
    }
    public static final Map<Integer, String> MapDatasetPath_undirectGraph = new HashMap<Integer, String>();
    static {
        MapDatasetPath_undirectGraph.put(0, "p2p-Gnutella08.txt");
        MapDatasetPath_undirectGraph.put(1, "p2p-Gnutella09.txt");
        MapDatasetPath_undirectGraph.put(2, "CA-GrQc.txt");
        MapDatasetPath_undirectGraph.put(3, "Email-Enron.txt");
        MapDatasetPath_undirectGraph.put(4, "p2p-Gnutella31.txt");
        MapDatasetPath_undirectGraph.put(5, "CA-CondMat.txt");
        MapDatasetPath_undirectGraph.put(6, "CA-AstroPh.txt");
        MapDatasetPath_undirectGraph.put(7, "com-dblp.ungraph.txt");
        MapDatasetPath_undirectGraph.put(8, "roadNet-TX.txt");
    }

    /**
     * probability graph
     **/
    public static final Map<Integer, String> MapDatasetName_ProbGraph = new HashMap<Integer, String>();
    static {
        MapDatasetName_ProbGraph.put(0, "testdata/prograph4");
    }
    public static final Map<Integer, String> MapDatasetPath_ProbGraph = new HashMap<Integer, String>();
    static {
        MapDatasetPath_ProbGraph.put(0, "testdata/prograph4");
    }

}
