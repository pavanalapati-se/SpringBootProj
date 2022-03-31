package com.epam.controller;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.epam.dto.AppointmentDTO;
import com.epam.service.AppointmentService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = AppointmentController.class) 
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
class AppointmentControllerTest {

	@MockBean 
	private AppointmentService appointmentService;

	@Autowired
	private MockMvc mockMvc;

	@BeforeEach
	void setUp() throws Exception {

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	// Todo:
	// getAppointment 1. N Size of the appointments
	// 2. no appointments

	@Test
	public void testGetAppointmentForNSize() throws Exception {

		AppointmentDTO appoinmentFirst = new AppointmentDTO();
		appoinmentFirst.setAppointmentId(100);
		appoinmentFirst.setVaccineDoseNumber("vaccine1");
		appoinmentFirst.setDate(LocalDate.of(2022, 4, 1));
		appoinmentFirst.setLocation("Hyderabad");

		AppointmentDTO appoinmentSecond = new AppointmentDTO();
		appoinmentSecond.setAppointmentId(101);
		appoinmentSecond.setVaccineDoseNumber("vaccine2");
		appoinmentSecond.setDate(LocalDate.of(2022, 4, 1));
		appoinmentSecond.setLocation("Hyderabad");

		List<AppointmentDTO> appointmentList = new ArrayList<>();
		appointmentList.add(appoinmentFirst);
		appointmentList.add(appoinmentSecond);

		given(appointmentService.getAppointments()).willReturn(appointmentList);

		mockMvc.perform(get("/appointments")).andExpect(status().isOk()).andExpect(view().name("viewAppointments"))
				.andExpect(model().attribute("appointments", hasSize(2)))
				.andExpect(model().attribute("appointments", hasItem(allOf(hasProperty("appointmentId", is(100)),
						hasProperty("vaccineDoseNumber", is("vaccine1")),
						hasProperty("date", is(LocalDate.of(2022, 4, 1))), hasProperty("location", is("Hyderabad"))))));

		verify(appointmentService, times(1)).getAppointments();

	}

}
