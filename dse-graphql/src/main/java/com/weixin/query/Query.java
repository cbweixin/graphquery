package com.weixin.query;


import com.coxautodev.graphql.tools.GraphQLRootResolver;

public class Query implements GraphQLRootResolver {

//    private final LinkRepository linkRepository;
    private final ContactSourceRepository contactSourceRepository;

//    public Query(LinkRepository linkRepository) {
//        this.linkRepository = linkRepository;
//    }

    public Query(ContactSourceRepository contactSourceRepository){
        this.contactSourceRepository = contactSourceRepository;

    }

//    public List<Link> allLinks() {
//        return linkRepository.getAllLinks();
//    }

    public ContactSource contactSource(String sourceId, String sourceType) {
        return contactSourceRepository.getContactSource(sourceId, sourceType);
    }
}
