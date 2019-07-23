package com.tazz009.jpa.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.tazz009.jpa.entities.Member;

@Repository
public class MemberRepositoryImpl implements MemberRepository {

	@PersistenceContext
	private EntityManager em;

	public Member save(Member member) {
		return em.merge(member);
	}

	public List<Member> findAllByTypedQuery() {
		TypedQuery<Member> query = em.createQuery("SELECT m FROM Member m", Member.class);
		List<Member> resultList = query.getResultList();
		return resultList;
	}
	

	public List findAllByQuery() {
		Query query = em.createQuery("SELECT m FROM Member m");
		List<Member> resultList = query.getResultList();
		return resultList;
	}

	public List<Member> findAllByParameter(Member member) {
		TypedQuery<Member> query = em.createQuery(
				"SELECT m FROM Member m where m.name = :name"
				, Member.class);
		query.setParameter("name", member.getName());
		List<Member> resultList = query.getResultList();
		return resultList;
	}

	public List<Object[]> findAllByProjection() {
		Query query = em.createQuery("SELECT m.name, m.age FROM Member m");
		List<Object[]> resultList = query.getResultList();
		return resultList;
	}

	public List<Member> findAllWithPaging(int startPosition, int maxResult) {
		TypedQuery<Member> query = em.createQuery("SELECT m FROM Member m", Member.class);
		query.setFirstResult(startPosition);
		query.setMaxResults(maxResult);
		List<Member> resultList = query.getResultList();
		return resultList;
	}

	public Object[] findAllWithAnalistic() {
		Query query = em.createQuery(
				"SELECT COUNT(m), SUM(m.age), AVG(m.age), MAX(m.age), MIN(m.age) FROM Member m");
		Object[] result = (Object[]) query.getSingleResult();
		return result;
	}
	
}
