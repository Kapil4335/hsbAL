package com.crif.cff.brk.hsbcb.routes.otp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crif.cff.brk.hsbcb.routes.otp.entity.OtpEntity;

@Repository
public interface OtpRepository extends JpaRepository<OtpEntity, Long>{

	Optional<OtpEntity> findByEktpNumber(String ektpNumber);
}
