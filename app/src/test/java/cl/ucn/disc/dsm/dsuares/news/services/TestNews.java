/*
 * Copyright 2020. Daniel Suares-Suares, daniel.suares@alumnos.ucn.cl
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package cl.ucn.disc.dsm.dsuares.news.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;

import cl.ucn.disc.dsm.dsuares.news.model.News;


/**
 * Testing of News.
 *
 * @author Daniel Suares-Suares.
 */
public final class TestNews {

    /**
     * The Logger
     */
    private static final Logger log = LoggerFactory.getLogger(TestNews.class);

    /**
     * Testing the constructor
     */
    @Test
    public void testConstructor() {

        log.debug("Testing ..");

        // All data ok
        News news = new News("The Title", "The Source", "The Author", "The URL", "The URL Image", "The Description", "The Content", ZonedDateTime.now(ZoneId.of("-3")));

        log.debug("The id: {}.", news.getId());

        log.debug("Title null ..");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            new News(null, "The source", "The Author", "The URL", "The URL Image", "The Description", "The Content", ZonedDateTime.now(ZoneId.of("-3"))
            );
        });

        log.debug("Source null ..");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            new News("The Title", null, "The Author", "The URL", "The URL Image", "The Description", "The Content", ZonedDateTime.now(ZoneId.of("-3"))
            );
        });

        log.debug("Author null ..");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            new News("The Title", "The Source", null, "The URL", "The URL Image", "The Description", "The Content", ZonedDateTime.now(ZoneId.of("-3"))
            );
        });

        log.debug("URL null ..");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            new News("The Title", "The Source", "The Author", null, "The URL Image", "The Description", "The Content", ZonedDateTime.now(ZoneId.of("-3"))
            );
        });

        log.debug("URL Image null ..");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            new News("The Title", "The Source", "The Author", "The URL", null, "The Description", "The Content", ZonedDateTime.now(ZoneId.of("-3"))
            );
        });

        log.debug("Description null ..");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            new News("The Title", "The Source", "The Author", "The URL", "The URL Image", null, "The Content", ZonedDateTime.now(ZoneId.of("-3"))
            );
        });

        log.debug("Content null ..");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            new News("The Title", "The Source", "The Author", "The URL", "The URL Image", "The Description", null, ZonedDateTime.now(ZoneId.of("-3"))
            );
        });

        log.debug("Content null ..");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            new News("The Title", "The Source", "The Author", "The URL", "The URL Image", "The Description", null, ZonedDateTime.now(ZoneId.of("-3"))
            );
        });

        log.debug("PublishedAt  null ..");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            new News("The Title", "The Source", "The Author", "The URL", "The URL Image", "The Description", "The Content", null
            );
        });

        log.debug(".. Done!");
    }
}

