package com.jorgenlohne.deviationTracker.controller

import com.jorgenlohne.deviationTracker.model.Deviation
import com.jorgenlohne.deviationTracker.service.DeviationService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class DeviationController(val service: DeviationService) {


    /**
     * Endpoint for sanity checking
     * */
    @GetMapping("hello")
    fun sanityCheck(): String {
        return "Hello!"
    }

    /**
     * Get all current deviations
     * */
    @GetMapping("all")
    fun getAll(): Iterable<Deviation> {
        return service.getAllDeviations()
    }


    /**
     * Get deviations by route, if there is a deviation for the route
     * */
    @GetMapping("route")
    fun getRoute(@RequestParam("route") routes: List<String>): Iterable<Deviation> {
        return service.getDeviationsByRoute(routes)
    }


    /**
     * Get routes that are experiencing a deviation
     * */
    @GetMapping("active")
    fun getRoutes(): Iterable<String> {
        return service.getCurrentDeviationRoutes()
    }

}