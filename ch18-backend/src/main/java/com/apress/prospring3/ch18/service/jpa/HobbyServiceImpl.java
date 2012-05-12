/**
 * Created on Dec 29, 2011
 */
package com.apress.prospring3.ch18.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apress.prospring3.ch18.domain.Hobby;
import com.apress.prospring3.ch18.repository.HobbyRepository;
import com.apress.prospring3.ch18.service.HobbyService;
import com.google.common.collect.Lists;

/**
 * @author Clarence
 *
 */
@Service("hobbyService")
@Repository
@Transactional
public class HobbyServiceImpl implements HobbyService {

	@Autowired
	private HobbyRepository hobbyRepository;

	@Transactional(readOnly=true)
	public List<Hobby> findAll() {
		return Lists.newArrayList(hobbyRepository.findAll());
	}

}
