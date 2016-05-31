package com.merryyou.elasticsearch;

import org.apache.htrace.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;

import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by YourName on 2015/11/23 0023.
 */
public class TestDemo {
    @Test
    public void testAdd() throws UnknownHostException {
        Client client = ESUtils.getClient();
        IndexResponse indexResponse;
        indexResponse = client.prepareIndex().setIndex(ESUtils.getIndexName())
                .setType(ESUtils.getTypeName())
                .setSource("{\"prodId\":1,\"prodName\":\"ipad5\",\"prodDesc\":\" 比你想的更强大\",\"catId\":1}")
                .setId("1")
                .execute()
                .actionGet();
        System.out.println("添加成功,isCreated=" + indexResponse.isCreated());
        ESUtils.closeClient(client);
    }

    @Test
    public void testSerarch() throws UnknownHostException {
        Client client = ESUtils.getClient();
        GetResponse getResponse =
                client.prepareGet().setIndex(ESUtils.INDEX_NAME)
                        .setType(ESUtils.TYPE_NAME)
                        .setId("1")
                        .execute()
                        .actionGet();
        System.out.println("get=" + getResponse.getSourceAsString());
        ESUtils.closeClient(client);
    }

    @Test
    public void testAddTwo() throws UnknownHostException {
        Client client = ESUtils.getClient();
        IndexResponse indexResponse;
        indexResponse = client.prepareIndex().setIndex(ESUtils.getIndexName())
                .setType(ESUtils.getTypeName())
                .setSource("{\"prodId\":2,\"prodName\":\"ipad\",\"prodDesc\":\" 比你想的更强大的多\",\"catId\":2}")
                .setId("2")
                .execute()
                .actionGet();
        System.out.println("添加成功,isCreated=" + indexResponse.isCreated());
        ESUtils.closeClient(client);
    }

    @Test
    public void testUpdate() throws UnknownHostException {
        Client client = ESUtils.getClient();
        GetResponse getResponse =
                client.prepareGet().setIndex(ESUtils.getIndexName())
                        .setType(ESUtils.getTypeName())
                        .setId("1")
                        .execute()
                        .actionGet();
        System.out.println("berfore update version=" + getResponse.getVersion());
        UpdateResponse updateResponse =
                client.prepareUpdate().setIndex(ESUtils.getIndexName())
                        .setType(ESUtils.getTypeName())
                        .setDoc("{\"prodId\":1,\"prodName\":\"ipad5\",\"prodDesc\":\"比你想的更强大噢耶\",\"catId\":1}")
                        .setId("1")
                        .execute()
                        .actionGet();
        System.out.println("更新成功，isCreated=" + updateResponse.isCreated());
        getResponse =
                client.prepareGet().setIndex(ESUtils.getIndexName())
                        .setType(ESUtils.getTypeName())
                        .setId("1")
                        .execute()
                        .actionGet();
        System.out.println("after get version=" + getResponse.getVersion());
        ESUtils.closeClient(client);
    }

    @Test
    public void testDelete() throws UnknownHostException {
        Client client = ESUtils.getClient();
        QueryBuilder query = QueryBuilders.queryStringQuery("ipad5");
        SearchResponse response = client.prepareSearch(ESUtils.INDEX_NAME)
        //设置查询条件,
                .setQuery(query)
                .setFrom(0).setSize(60)
                .execute()
                .actionGet();
        /**
         * SearchHits是SearchHit的复数形式，表示这个是一个列表
         */
        SearchHits shs = response.getHits();
        System.out.println("总共有：" + shs.hits().length);
        for (SearchHit hit : shs) {
            System.out.println(hit.getSourceAsString());
        }
        ESUtils.closeClient(client);
    }
    @Test
    public void testPulk() throws UnknownHostException{
       /* Client client = ESUtils.getClient();
        BulkRequestBuilder bulkRequest = client.prepareBulk();
        User user = new User();
        for(int i=1;i<40001;i++){
            user.setName(RandomData.randomName("user_"));
            SecureRandom random = new SecureRandom();
            long l = Math.abs(random.nextLong());
            user.setWeight(l);
            user.setMarried(l%1==0?true:false);
            user.setAge(l%2==0?28:82);
            IndexRequestBuilder ir =
                    client.prepareIndex(ESUtils.INDEX_NAME,
                            ESUtils.USER_TYPE,
                            String.valueOf(i)).setSource(Utils.toJson(user));
            bulkRequest.add(ir);
        }
        long beginTime = System.currentTimeMillis();
        BulkResponse bulkResponse = bulkRequest.execute().actionGet();
        long useTime = System.currentTimeMillis() - beginTime;
//1406ms
        System.out.println("useTime:" + useTime);
        if (bulkResponse.hasFailures()) {
// process failures by iterating through each bulk response item
        }*/
    }
    @Test
    public void testAddAll() throws UnknownHostException{

        for (int i=71;i<100;i++){
            Client client = ESUtils.getClient();
            IndexResponse indexResponse;
            indexResponse = client.prepareIndex().setIndex(ESUtils.getIndexName())
                    .setType(ESUtils.getTypeName())
                    .setSource("{\"prodId\":" + i + ",\"prodName\":\"ipad" + (i-50) + "\",\"prodDesc\":\" 比你想的更强大的多" + i + "\",\"catId\":" + i + ",\"time\":"+new Date().getTime()+"}")
                    .setId(i + "")
                    .execute()
                    .actionGet();
            System.out.println("添加成功,isCreated=" + indexResponse.isCreated());
            ESUtils.closeClient(client);
        }

    }
    @Test
    public void testSearchHight() throws UnknownHostException{
        Client client = ESUtils.getClient();
        //设置查询索引
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch(ESUtils.INDEX_NAME);
        //设置查询  类型
        searchRequestBuilder.setTypes(ESUtils.TYPE_NAME);
        // 设置查询类型 1.SearchType.DFS_QUERY_THEN_FETCH = 精确查询 2.SearchType.SCAN =
        // 扫描查询,无序
        searchRequestBuilder.setSearchType(SearchType.DFS_QUERY_THEN_FETCH);
        searchRequestBuilder.setQuery(QueryBuilders.matchQuery("prodId", "14"));

        //
        // 设置是否按查询匹配度排序
        searchRequestBuilder.setExplain(true);

        // 执行搜索,返回搜索响应信息
        SearchResponse response = searchRequestBuilder.execute().actionGet();
        SearchHits searchHits = response.getHits();
        SearchHit[] hits = searchHits.getHits();
        for (int i = 0; i < hits.length; i++) {
            SearchHit hit = hits[i];
            Map<String, Object> result = hit.getSource();
            System.out.println(result);
        }
        System.out.println("search success ..");
    }

    @Test
    public void testSearchLike() throws UnknownHostException{
        Client client = ESUtils.getClient();
        //设置查询索引
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch("logstash-2015.11.20");
        //设置查询  类型
        searchRequestBuilder.setTypes("16-mts-ci");
        // 设置查询类型 1.SearchType.DFS_QUERY_THEN_FETCH = 精确查询 2.SearchType.SCAN =
        // 扫描查询,无序
       // searchRequestBuilder.setSearchType(SearchType.DEFAULT);
       // searchRequestBuilder.setQuery(QueryBuilders.matchQuery("prodId", "14"));
       // searchRequestBuilder.addSort("message", SortOrder.ASC);
        //searchRequestBuilder.setQuery(QueryBuilders.prefixQuery("prodName","ipad")).setFrom(5).setSize(10);
        //searchRequestBuilder.setQuery(QueryBuilders.queryStringQuery("initcheck ").field("message"));
        //"type": "16-mts-ci",
        //QueryBuilders.fuzzyQuery("message","23").fuzziness(Fuzziness.ONE);
        searchRequestBuilder.setQuery(QueryBuilders.fuzzyQuery("message","mts").fuzziness(Fuzziness.TWO).boost(1.0f).prefixLength(0).maxExpansions(100));
       // searchRequestBuilder.setQuery(QueryBuilders.matchQuery("prodId", "20"));

        //
        // 设置是否按查询匹配度排序
        //searchRequestBuilder.setExplain(true);
        // 执行搜索,返回搜索响应信息
        SearchResponse response = searchRequestBuilder.execute().actionGet();
        SearchHits searchHits = response.getHits();
        SearchHit[] hits = searchHits.getHits();
        for (int i = 0; i < hits.length; i++) {
            SearchHit hit = hits[i];
            Map<String, Object> result = hit.getSource();
            System.out.println(result);
        }
        System.out.println("search success ..");
    }
    @Test
    public void testSearchLike1() throws UnknownHostException{
        Client client = ESUtils.getClient();
        //设置查询索引
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch(ESUtils.INDEX_NAME);
        //设置查询  类型
        searchRequestBuilder.setTypes(ESUtils.TYPE_NAME);
        // 设置查询类型 1.SearchType.DFS_QUERY_THEN_FETCH = 精确查询 2.SearchType.SCAN =
        // 扫描查询,无序
       // searchRequestBuilder.setSearchType(SearchType.DEFAULT);
       // searchRequestBuilder.setQuery(QueryBuilders.matchQuery("prodId", "14"));
       // searchRequestBuilder.addSort("message", SortOrder.ASC);
        //searchRequestBuilder.setQuery(QueryBuilders.prefixQuery("prodName","ipad")).setFrom(5).setSize(10);
        //searchRequestBuilder.setQuery(QueryBuilders.queryStringQuery("initcheck ").field("message"));
        //"type": "16-mts-ci",
        //QueryBuilders.fuzzyQuery("message","23").fuzziness(Fuzziness.ONE);
        searchRequestBuilder.setQuery(QueryBuilders.fuzzyQuery("prodDesc","大").fuzziness(Fuzziness.TWO).boost(1.0f).prefixLength(0).maxExpansions(100));
       // searchRequestBuilder.setQuery(QueryBuilders.matchQuery("prodId", "20"));

        //
        // 设置是否按查询匹配度排序
        //searchRequestBuilder.setExplain(true);
        // 执行搜索,返回搜索响应信息
        SearchResponse response = searchRequestBuilder.execute().actionGet();
        SearchHits searchHits = response.getHits();
        SearchHit[] hits = searchHits.getHits();
        for (int i = 0; i < hits.length; i++) {
            SearchHit hit = hits[i];
            Map<String, Object> result = hit.getSource();
            System.out.println(result);
        }
        System.out.println("search success ..");
    }
    @Test
    public void testSearchTwo() throws UnknownHostException{
        ObjectMapper mapper = new ObjectMapper();

        Client client = ESUtils.getClient();
        //设置查询索引
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch("logstash-2016.03.22");
        //设置查询  类型
        searchRequestBuilder.setTypes("37-mts");
        // 设置查询类型 1.SearchType.DFS_QUERY_THEN_FETCH = 精确查询 2.SearchType.SCAN =
        // 扫描查询,无序
        //searchRequestBuilder.setSearchType(SearchType.DFS_QUERY_THEN_FETCH);
        // searchRequestBuilder.setQuery(QueryBuilders.matchQuery("_id", "Yatn9vUgScOKaNQnphWF2A"));
       // BoolQueryBuilder must = QueryBuilders.boolQuery().must(QueryBuilders.termQuery("path", "/IDS/tomcat-mts-ci/logs/mts-ci/ci_2015-11-28_1.log"));
       // searchRequestBuilder.setQuery(QueryBuilders.matchQuery("_id", "Yatn9vUgScOKaNQnphWF2A"));
        //searchRequestBuilder.setQuery(must);
        searchRequestBuilder.setQuery(QueryBuilders.matchPhrasePrefixQuery("message","1")).setFrom(0).setSize(20);
        //
        // 设置是否按查询匹配度排序
        //searchRequestBuilder.setExplain(true);
       // searchRequestBuilder.addSort("@version", SortOrder.ASC);
        // 执行搜索,返回搜索响应信息
        // 设置是否按查询匹配度排序
        searchRequestBuilder.setExplain(true);
        // 设置按时间逆序排序
        searchRequestBuilder.addSort("read_time", SortOrder.DESC);
        searchRequestBuilder.addSort("_score", SortOrder.DESC);
        SearchResponse response = searchRequestBuilder.execute().actionGet();
        SearchHits searchHits = response.getHits();
        SearchHit[] hits = searchHits.getHits();
        for (int i = 0; i < hits.length; i++) {
            SearchHit hit = hits[i];
            Map<String, Object> result = hit.getSource();
            System.out.println(result.get("message"));
        }
        System.out.println("search success ..");
    }

    @Test
    public void testSearchFilter() throws UnknownHostException{
        Client client = ESUtils.getClient();
        //设置查询索引
        SearchRequestBuilder builder = client.prepareSearch("logstash-2015.11.20");
        //设置查询  类型
        builder.setTypes("16-mts-ci3");
//        FilterBuilder inFilter = FilterBuilders.inFilter("type","16mts");
//        builder.setPostFilter(inFilter);

       // builder.setQuery(QueryBuilders.matchQuery("prodId", "4"));
        SearchResponse response = builder.execute().actionGet();
        SearchHits searchHits = response.getHits();
        SearchHit[] hits = searchHits.getHits();
        for (int i = 0; i < hits.length; i++) {
            SearchHit hit = hits[i];
            Map<String, Object> result = hit.getSource();
            System.out.println(result);
        }
        System.out.println("search success ..");
        client.close();
    }

    @Test
    public void testSearchFilterServer() throws UnknownHostException{
        Client client = ESUtils.getClient();
        //设置查询索引
        SearchRequestBuilder builder = client.prepareSearch("logstash-2016.01.01");
        //设置查询  类型
        builder.setTypes("15-mts-ci");
        RangeQueryBuilder queryBuilder = new RangeQueryBuilder("read_time");
        queryBuilder.gt("2016-01-01T08:16:54.856+08:00");
        BoolQueryBuilder must = QueryBuilders.boolQuery().must(queryBuilder);
        builder.setQuery(must).setSize(3);
        SearchResponse response = builder.execute().actionGet();
        SearchHits searchHits = response.getHits();
        SearchHit[] hits = searchHits.getHits();
        queryBuilder.lt("2016-01-01T08:16:54.856+08:00");
        BoolQueryBuilder must1 = QueryBuilders.boolQuery().must(queryBuilder);
        builder.setQuery(must1).setSize(3);
        SearchResponse response1 = builder.execute().actionGet();
        SearchHits searchHits1 = response1.getHits();
        SearchHit[] hits1 = searchHits1.getHits();
        SearchHit[] hits3 = new SearchHit[hits.length+hits1.length];
        for(int i=0;i<hits.length;i++){
            hits3[i]=hits[i];
        }
        for(int i=0;i<hits1.length;i++){
            hits3[hits.length+i]=hits1[i];
        }
        for (int i = 0; i < hits3.length; i++) {
            SearchHit hit = hits3[i];
            Map<String, Object> result = hit.getSource();
            System.out.println(result);
        }
        System.out.println("search success ..");
        client.close();
    }
    /*@Test
    public void testcase() throws Exception{
        String str="logstash-2015.11.20";
        String[] strArr = str.split("-");
        String strPre = strArr[0];
        String strEnd = strArr[1];
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy.MM.dd");
        String format = sf.format(date);
        Date parse = sf.parse(strEnd);
        Calendar cal=Calendar.getInstance();
        cal.setTime(parse);
        cal.add(Calendar.DATE, -1);  //减1天
        System.out.println(strPre+"-"+sf.format(cal.getTime()));
//        System.out.println(format);
//        System.out.println(parse.toString());
    }

    @Test
    public static String[] testDay() throws Exception{
        String str="logstash-2015.11.20";
        String[] reStr=new String[5];
        reStr[0] = str;
        String newStr=get(str,1);
        for(int i=1;i<=4;i++){
            reStr[i]=get(str,i);
        }
      return reStr;
    }
    public static String get(String str , int i) throws Exception{
        String[] strArr = str.split("-");
        String strPre = strArr[0];
        String strEnd = strArr[1];
        SimpleDateFormat sf = new SimpleDateFormat("yyyy.MM.dd");
        Date parse = sf.parse(strEnd);
        Calendar cal=Calendar.getInstance();
        cal.setTime(parse);
        cal.add(Calendar.DATE, - i);  //减1天
        return strPre+"-"+sf.format(cal.getTime());
    }*/
    public static SearchHit[] search1() throws Exception{
        Client client = ESUtils.getClient();
        //设置查询索引
        SearchRequestBuilder builder = client.prepareSearch("logstash-2016.01.01");
        //设置查询  类型
        builder.setTypes("15-mts-ci");
        RangeQueryBuilder queryBuilder = new RangeQueryBuilder("read_time");
        queryBuilder.gt("2016-01-01T08:16:54.856+08:00");
        BoolQueryBuilder must = QueryBuilders.boolQuery().must(queryBuilder);
        builder.setQuery(must).setSize(3);
        SearchResponse response = builder.execute().actionGet();
        SearchHits searchHits = response.getHits();
        SearchHit[] hits = searchHits.getHits();
        client.close();
        return hits;
    }

    public static SearchHit[] search2() throws Exception{
        Client client = ESUtils.getClient();
        //设置查询索引
        SearchRequestBuilder builder = client.prepareSearch("logstash-2016.01.01");
        //设置查询  类型
        builder.setTypes("15-mts-ci");
        RangeQueryBuilder queryBuilder = new RangeQueryBuilder("read_time");
        queryBuilder.lt("2016-01-01T08:16:54.856+08:00");
        BoolQueryBuilder must = QueryBuilders.boolQuery().must(queryBuilder);
        builder.setQuery(must).setSize(3);
        SearchResponse response = builder.execute().actionGet();
        SearchHits searchHits = response.getHits();
        SearchHit[] hits = searchHits.getHits();
        client.close();
        return hits;
    }

    public static void main1(String[] args) throws Exception {
        SearchHit[] hits = TestDemo.search1();
        SearchHit[] hits1 = TestDemo.search2();
        SearchHit[] hits3 = new SearchHit[hits.length+hits1.length];

        for(int i=0;i<hits.length;i++){
            hits3[i]=hits[i];
        }
        for(int i=0;i<hits1.length;i++){
            hits3[hits.length+i]=hits1[i];
        }
        for (int i = 0; i < hits3.length; i++) {
            SearchHit hit = hits3[i];
            Map<String, Object> result = hit.getSource();
            System.out.println(result);
        }
    }

    public static void main(String[] args)throws Exception {
        String str = "2016-01-07T16:22:27.313+08:00";
        String str1 = str.substring(0,str.indexOf("+")-4);
        SimpleDateFormat dateFormat =
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = dateFormat.parse(str1.replace("T"," "));
        Date date1=decDate(date);
        String str2=dateFormat.format(date1);
        String str3=str2.replace(" ","T")+str.substring(str.indexOf("+")-4,str.length());
        System.out.println(str3);
    }
       // Date date = new Date();

    public static Date addDate(Date date) {
        Calendar calendar = Calendar.getInstance();//获得当前时间
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, 5);//加20秒
        return calendar.getTime();//返回Date类
    }
    public static Date decDate(Date date) {
        Calendar calendar = Calendar.getInstance();//获得当前时间
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, -5);//加20秒
        return calendar.getTime();//返回Date类
    }

    @Test
    public  void search3() throws Exception{
        Client client = ESUtils.getClient();
        //设置查询索引
        SearchRequestBuilder builder = client.prepareSearch("logstash-2016.01.08");
        //设置查询  类型
        builder.setTypes("15-mts-ci");
        RangeQueryBuilder queryBuilder = new RangeQueryBuilder("read_time");
        queryBuilder.lt("2016-01-08T09:21:33.728 08:00");
        queryBuilder.gt("2016-01-08T09:21:23.728 08:00");
        BoolQueryBuilder must = QueryBuilders.boolQuery().must(queryBuilder);
        SearchResponse response = builder.execute().actionGet();
        builder.setQuery(must).setSize(201);
        SearchHits searchHits = response.getHits();
        SearchHit[] hits = searchHits.getHits();
        client.close();
        for (int i = 0; i < hits.length; i++) {
            SearchHit hit = hits[i];
            Map<String, Object> result = hit.getSource();
            System.out.println(result);
        }
    }
    @Test
    public  void search4() throws Exception{
        Client client = ESUtils.getClient();
        //设置查询索引
        SearchRequestBuilder builder = client.prepareSearch("logstash-2016.01.07");
        //设置查询  类型
        builder.setTypes("15-mts-ci");
        RangeQueryBuilder queryBuilder = new RangeQueryBuilder("read_time");
        queryBuilder.lt("2016-01-07T09:21:33.728+08:00");
        queryBuilder.gt("2016-01-07T09:21:23.728+08:00");
        BoolQueryBuilder must = QueryBuilders.boolQuery().must(queryBuilder);
        builder.setQuery(must).setSize(201);
        SearchResponse response = builder.execute().actionGet();
        SearchHits searchHits = response.getHits();
        SearchHit[] hits = searchHits.getHits();
        client.close();
        List<Map<String,Object>> list =new ArrayList<Map<String,Object>>();
        for (int i = 0; i < hits.length; i++) {
            SearchHit hit = hits[i];
            Map<String, Object> result = hit.getSource();

            list.add(result);
            System.out.println(result);
        }
        System.out.println("success");
    }
    @Test
    public  void search5() throws Exception{
        Client client = ESUtils.getClient();
        //设置查询索引
        SearchRequestBuilder builder = client.prepareSearch(ESUtils.getIndexName());
        //设置查询  类型
        builder.setTypes(ESUtils.getTypeName());
       // RangeQueryBuilder queryBuilder = new RangeQueryBuilder("time").from(1452218113462l).to(1452218117510l);
//        RangeQueryBuilder queryBuilder = new RangeQueryBuilder("time");
//        queryBuilder.lt(1452218117510l);
//        queryBuilder.gt(1452218113462l);
        RangeQueryBuilder queryBuilder = new RangeQueryBuilder("time");
        queryBuilder.lt(1452218117510l);
        queryBuilder.gt(1452218113462l);
        BoolQueryBuilder must = QueryBuilders.boolQuery().must(queryBuilder);
        builder.setQuery(must).setSize(200).addSort("time", SortOrder.DESC);
        SearchResponse response = builder.execute().actionGet();
        SearchHits searchHits = response.getHits();
        SearchHit[] hits = searchHits.getHits();
        client.close();
        for (int i = 0; i < hits.length; i++) {
            SearchHit hit = hits[i];
            Map<String, Object> result = hit.getSource();
            System.out.println(result);
        }
    }
}
