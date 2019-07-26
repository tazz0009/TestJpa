package com.tazz009.jpa.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.tazz009.jpa.entities.Member;

@Repository
public class MemberCustRepositoryImpl implements MemberCustRepository {

	@PersistenceContext
	private EntityManager em;

	
	public List<Member> findMemberWithInnerJoin(String teamName) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT m					");	
		sb.append("  FROM Member m			");
		sb.append(" INNER JOIN m.team t 	");
		sb.append(" WHERE t.name = :teamName");
		
		List<Member> resultList = em.createQuery(sb.toString(), Member.class)
				.setParameter("teamName", teamName)
				.getResultList();
		return resultList;
	}

	public List<Object[]> findMemberWithInnerJoin2(String teamName) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT m.username, t.name");	
		sb.append("  FROM Member m			");
		sb.append(" INNER JOIN m.team t 	");
		sb.append(" WHERE t.name = :teamName");
		sb.append(" ORDER BY m.age");
		
		@SuppressWarnings("unchecked")
		List<Object[]> resultList = em.createQuery(sb.toString())
				.setParameter("teamName", teamName)
				.getResultList();
		return resultList;
	}

	public List<Member> findMemberWithOuterJoin(String teamName) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT m						");	
		sb.append("  FROM Member m				");
		sb.append("  LEFT OUTER JOIN m.team t 	");
		sb.append(" on t.name = :teamName	");
		
		List<Member> resultList = em.createQuery(sb.toString(), Member.class)
				.setParameter("teamName", teamName)
				.getResultList();
		return resultList;
	}

	public List<Member> findMemberWithFetchJoin(String teamName) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT m				");	
		sb.append("  FROM Member m		");
		sb.append("  JOIN FETCH m.team 	");
//		sb.append(" WHERE t.name = :teamName	");
		
		List<Member> resultList = em.createQuery(sb.toString(), Member.class)
//				.setParameter("teamName", teamName)
				.getResultList();
		return resultList;
	}

}
