package com.example.demo.controller;

import com.zabbix4j.ZabbixApi;
import com.zabbix4j.ZabbixApiParamter;
import com.zabbix4j.host.HostGetRequest;
import com.zabbix4j.host.HostGetResponse;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author byron
 * @date 2019/3/22 14:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ZabbixTest{
  private ZabbixApi zabbixApi;

  @Before
  public void setUp() throws Exception {
    zabbixApi = new ZabbixApi("http://testlog.wintruelife.com/zabbix/api_jsonrpc.php");
    zabbixApi.login("Admin","zabbix");
  }

  //获取主机
  @Test
  public void testZabbix() throws Exception{
    HostGetRequest hostGetRequest =new HostGetRequest();
    HostGetRequest.Params params = hostGetRequest.getParams();
    ArrayList<Integer> hostIds = new ArrayList<>();
    hostIds.add(10254);
    params.setHostids(hostIds);
    params.setSelectDiscoveryRule(ZabbixApiParamter.QUERY.extend.name());
    params.setSelectGroups(ZabbixApiParamter.QUERY.extend.name());
    params.setSelectItems(ZabbixApiParamter.QUERY.extend.name());
    params.setSelectApplications(ZabbixApiParamter.QUERY.extend.name());
    params.setSelectDiscoveries(ZabbixApiParamter.QUERY.extend.name());
    params.setSelectGraphs(ZabbixApiParamter.QUERY.extend.name());
    params.setSelectHostDiscovery(ZabbixApiParamter.QUERY.extend.name());
    params.setSelectHttpTests(ZabbixApiParamter.QUERY.extend.name());
    params.setSelectInterfaces(ZabbixApiParamter.QUERY.extend.name());
    params.setSelectInventory(ZabbixApiParamter.QUERY.extend.name());
    params.setSelectMacros(ZabbixApiParamter.QUERY.extend.name());
    params.setSelectParentTemplates(ZabbixApiParamter.QUERY.extend.name());
    params.setSelectScreens(ZabbixApiParamter.QUERY.extend.name());
    params.setSelectTriggers(ZabbixApiParamter.QUERY.extend.name());
    zabbixApi.host().get(hostGetRequest);
    HostGetResponse response = zabbixApi.host().get(hostGetRequest);
    HostGetResponse.Result result = response.getResult().get(0);
    System.out.println(result);
  }

}
