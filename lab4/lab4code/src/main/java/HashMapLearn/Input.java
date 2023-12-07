package HashMapLearn;

public class Input {
    public static void main(String[] args) {
        KeywordCounter counter = new KeywordCounter();
        //测试选段:风！雨! | 莎士比亚《李尔王》选段欣赏
        //暴风雨继续未止。李尔及弄人上。
        //
        //                李尔 吹吧，风啊！胀破了你的脸颊，猛烈地吹吧！你，瀑布一样的倾盆大雨，尽管倒泻下来，浸没了我们的尖塔，淹沉了屋顶上的风标吧！你，思想一样迅速的硫磺的电火，劈碎橡树的巨雷的先驱，烧焦了我的白发的头颅吧！你，震撼一切的霹雳啊，把这生殖繁密的、饱满的地球击平了吧！打碎造物的模型，不要让一颗忘恩负义的人类的种子遗留在世上！
        //
        //                弄人 啊，老伯伯，在一间干燥的屋子里说几句好话，不比在这没有遮蔽的旷野里淋雨好得多吗？老伯伯，回到那所房子里去，向你的女儿们请求祝福吧；这样的夜无论对于聪明人或是傻瓜，都是不发一点慈悲的。
        //
        //                李尔 尽管轰着吧！尽管吐你的火舌，尽管喷你的雨水吧！雨、风、雷、电，都不是我的女儿，我不责怪你们的无情；我不曾给你们国土，不曾称你们为我的孩子，你们没有顺从我的义务；所以，随你们的高兴，降下你们可怕的威力来吧，我站在这儿，只是你们的奴隶，一个可怜的、衰弱的、无力的、遭人贱视的老头子。可是我仍然要骂你们是卑劣的帮凶，因为你们滥用上天的威力，帮同两个万恶的女儿来跟我这个白发的老翁作对。啊！啊！这太卑劣了！
        // 假设这是用户输入的字符串
        String input = """
                
                Storm still.Enter Lear and Fool.
                                
                LEAR
                Blow, winds, andcrack your cheeks! rage! blow!
                You cataracts and hurricanoes, spout
                Till you have drench'd our steeples, drown'd the cocks!
                You sulph'rous and thought-executing fires,
                Vaunt-couriers to oak-cleaving thunderbolts,
                Singe my white head! And thou, all-shaking thunder,
                Strike flat the thick rotundity o' th' world,
                Crack Nature's moulds, all germains spill at once,
                That makes ingrateful man!
                                
                FOOL
                O nuncle, courtholy water in a dry house is better than this
                rain water out o' door. Good nuncle, in, and ask thy daughters
                blessing! Here's a night pities nether wise men nor fools.
                                
                LEAR
                Rumble thybellyful! Spit, fire! spout, rain!
                Nor rain, wind, thunder, fire are my daughters.
                I tax not you, you elements, with unkindness.
                I never gave you kingdom, call'd you children,
                You owe me no subscription. Then let fall
                Your horrible pleasure. Here I stand your slave,
                A poor, infirm, weak, and despis'd old man.
                But yet I call you servile ministers,
                That will with two pernicious daughters join
                Your high-engender'd battles 'gainst a head
                So old and white as this! O! O! 'tis foul!
                
                 Apart from explicit hyperlinks, implicit authorship or similarities in
                 the content could also be exploited to construct an isomeric graph,
                 thus yielding multi-modal spatial dependencies. In such situations,
                 profound domain knowledge is required to construct an accurate
                 graph; however, human involvement may become not only costly
                 but also sub-optimal. To this end, we argue that jointly mining the
                 spatial dependencies and modeling temporal patterns in a coupled
                 framework may largely benefit spatiotemporal predictions, which
                 lead to our targeted goal, i.e., spatiotemporal-coupled prediction.
                 Three challenges exist regarding spatiotemporal-coupled predic
                tions. Firstly, from the data property aspect, there lacks existing
                 edge labels to learn the spatial dependencies in a supervised manner.
                 Moreover, the information of time series (i.e., historical observa
                tions with different timestamps) may be limited and noisy, making
                 it difficult to find the distance (i.e., correlation or causation) among
                 time series and cluster them as a graph [1]. Secondly, from the
                 learning aspect, without effective inductive bias, a model is easy
                 to overfit the noises and the learning procedure may become un
                stable. Since the spatial and temporal dependencies among vertices
                 couple compactly, the changes of spatial dependencies may make
                 learning temporal patterns more strenuous, and vice versa, espe
                cially when both sides are initialized from random states. Thirdly,
                 fromthepracticality aspect, mining potential links between two
                 arbitrary time series pairs also brings significant computational
                 burden, as the possible links are in n2 order, if we assume n time
                 series exist. Existing research concerning spatiotemporal predic
                tion is either based on predefined graph structure [16, 30] or can
                 only infer potential links with strong domain knowledge [11] or in
                 rather small graphs, e.g., with less than 400 vertices [28].
                 In this paper, we propose a novel Reciprocal Spatiotemporal
                 (REST) framework to address the aforementioned three challenges
                 synergistically. As illustrated in Figure 1 (details to be explained
                 in Section 4), the REST framework consists of two integral parts:
                 our introduced Edge Inference Networks (EINs) for mining spa
                tial dependencies among time series; and integrated GCNs, e.g.,
                 DCRNNs[16], for making spatiotemporal prediction. The spatial
                 dependencies inferred by EINs promote GCNs to make more accu
                rate prediction, while supervisedly trained GCNs help EINs learn
                 better distance measurement. To address the data property chal
                lenge, EINs project time series from time domain to frequency
                 domain, and thus fertilize the original time series data and quantify
                 the multi-modal spatial dependencies among them. To address the
                 practicality challenge, EINs firstly sample a fixed number of pos
                sible time series neighbors for all the central time series vertices
                 of interest before each training epoch, and then during the train
                ing procedure, EINs try to learn a more accurate distance function
                 with the help of the GCN part. Through such manner, the REST
                 framework can theoretically explore all possible linkages from the
                 whole dataset, while remain the sparsity of graph as kn
                 n2\s
                for training,
                 where k refers to predefined number of neighbor candidates and
                 k ≪n. To address the learning challenge, we propose a phased
                 heuristic approach as a warm-up to drive the REST framework. As
                 a consequence, such an iterative learning cycles within the REST
                 frameworkshallincrementallyenhancethespatiotemporal-coupled
                 prediction over time.
                 Our main contributions are three-fold""";

        counter.processInput(input);
        counter.printKeywordCounts(); // 输出每个关键字及其出现的次数
    }
}
