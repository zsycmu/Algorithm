package Facebook.SystemDesign;

/**
 * 
 * 系统设计，设计Twitter search, 后续内容需要自己问：QPS, DAU, text, 图片, audio均有可能，多个词的时候去and 的logic (比如 Facebook interview feedback 那么返回三个词都存在的) 

我的回答大致是设计简单的lookup service, DB的存储是每个词ID, 产生全局独增unique ID，所以每个词对应一个list的ID, 另一个integration service，用来算每个词对应ID list的integration
还有非tex存url

欢迎大神提点哪里没答到或者没答好
 * @author Shengyi
 *
 */

public class _01_twitter_search {

}
