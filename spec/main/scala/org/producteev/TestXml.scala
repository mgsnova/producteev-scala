package org.producteev

object TestXml {
  val dashboardList = """<?xml version="1.0" encoding="ISO-8859-1"?>
    <dashboards>
      <node>
        <dashboard>
          <id_dashboard>243972</id_dashboard>
          <id_creator>106531</id_creator>
          <title>privat</title>
          <write_ok>1</write_ok>
          <time_lastchange>Wed, 11 May 2011 21:06:39 +0200</time_lastchange>
          <status>1</status>
          <deleted>0</deleted>
          <smart_labels>0</smart_labels>
          <needs_upgrade>0</needs_upgrade>
          <accesslist>
            <node>
              <user>
                <id_user>106531</id_user>
                <firstname>first</firstname>
                <lastname>last</lastname>
                <company/>
                <email>mail@web.de</email>
                <timezone>Europe/Berlin</timezone>
                <time_signup>Wed, 11 May 2011 20:57:15 +0200</time_signup>
                <lang>1</lang>
                <avatar>http://producteev.com//static/images/default-avatar.jpg</avatar>
                <deleted>0</deleted>
                <default_dashboard>243972</default_dashboard>
                <sort_by>4</sort_by>
                <facebooks/>
                <colleagues/>
                <dashboard_status>1</dashboard_status>
              </user>
            </node>
          </accesslist>
        </dashboard>
      </node>
      <node>
        <dashboard>
          <id_dashboard>250322</id_dashboard>
          <id_creator>106531</id_creator>
          <title>second</title>
          <write_ok>1</write_ok>
          <time_lastchange>Wed, 25 May 2011 21:21:34 +0200</time_lastchange>
          <status>1</status>
          <deleted>0</deleted>
          <smart_labels>0</smart_labels>
          <needs_upgrade>0</needs_upgrade>
          <accesslist>
            <node>
              <user>
                <id_user>106531</id_user>
                <firstname>first</firstname>
                <lastname>last</lastname>
                <company/>
                <email>mail@web.de</email>
                <timezone>Europe/Berlin</timezone>
                <time_signup>Wed, 11 May 2011 20:57:15 +0200</time_signup>
                <lang>1</lang>
                <avatar>http://producteev.com//static/images/default-avatar.jpg</avatar>
                <deleted>0</deleted>
                <default_dashboard>243972</default_dashboard>
                <sort_by>4</sort_by>
                <facebooks/>
                <colleagues/>
                <dashboard_status>1</dashboard_status>
              </user>
            </node>
          </accesslist>
        </dashboard>
      </node>
    </dashboards>"""

  val dummy = """<tag>foo</tag>"""

  val time = """<?xml version="1.0" encoding="ISO-8859-1"?>
    <time>
      <value>Mon, 23 May 2011 16:22:41 -0400</value>
    </time>"""

  val userLogin = """<login>
       <token>a_session_token</token>
       <email>user@provider.com</email>
    </login>"""

  val userView = """<?xml version="1.0" encoding="ISO-8859-1"?>
    <user>
      <id_user>106531</id_user>
      <firstname>first</firstname>
      <lastname>last</lastname>
      <company>co</company>
      <email>mail@web.de</email>
      <timezone>Europe/Berlin</timezone>
      <time_signup>Wed, 11 May 2011 20:57:15 +0200</time_signup>
      <lang>1</lang>
      <avatar>http://producteev.com//static/images/default-avatar.jpg</avatar>
      <deleted>0</deleted>
      <default_dashboard>243972</default_dashboard>
      <sort_by>4</sort_by>
      <facebooks/>
      <colleagues/>
    </user>"""

  val userListItem = """<?xml version="1.0" encoding="ISO-8859-1"?>
    <node>
      <user>
        <id_user>106531</id_user>
        <firstname>first</firstname>
        <lastname>last</lastname>
        <company>co</company>
        <email>mail@web.de</email>
        <timezone>Europe/Berlin</timezone>
        <time_signup>Wed, 11 May 2011 20:57:15 +0200</time_signup>
        <lang>1</lang>
        <avatar>http://producteev.com//static/images/default-avatar.jpg</avatar>
        <deleted>0</deleted>
        <default_dashboard>243972</default_dashboard>
        <sort_by>4</sort_by>
        <facebooks/>
        <colleagues/>
        <dashboard_status>1</dashboard_status>
      </user>
    </node>"""

  val dashboardView = """<?xml version="1.0" encoding="ISO-8859-1"?>
    <dashboard>
      <id_dashboard>250322</id_dashboard>
      <id_creator>106531</id_creator>
      <title>second</title>
      <write_ok>1</write_ok>
      <time_lastchange>Wed, 25 May 2011 21:21:34 +0200</time_lastchange>
      <status>1</status>
      <deleted>0</deleted>
      <smart_labels>0</smart_labels>
      <needs_upgrade>0</needs_upgrade>
      <accesslist>
        <node>
          <user>
            <id_user>106531</id_user>
            <firstname>first</firstname>
            <lastname>last</lastname>
            <company/>
            <email>mail@web.de</email>
            <timezone>Europe/Berlin</timezone>
            <time_signup>Wed, 11 May 2011 20:57:15 +0200</time_signup>
            <lang>1</lang>
            <avatar>http://producteev.com//static/images/default-avatar.jpg</avatar>
            <deleted>0</deleted>
            <default_dashboard>243972</default_dashboard>
            <sort_by>4</sort_by>
            <facebooks/>
            <colleagues/>
            <dashboard_status>1</dashboard_status>
          </user>
        </node>
      </accesslist>
    </dashboard>"""

  val dashboardListItem = """<?xml version="1.0" encoding="ISO-8859-1"?>
    <node>
      <dashboard>
        <id_dashboard>250322</id_dashboard>
        <id_creator>106531</id_creator>
        <title>second</title>
        <write_ok>1</write_ok>
        <time_lastchange>Wed, 25 May 2011 21:21:34 +0200</time_lastchange>
        <status>1</status>
        <deleted>0</deleted>
        <smart_labels>0</smart_labels>
        <needs_upgrade>0</needs_upgrade>
        <accesslist>
          <node>
            <user>
              <id_user>106531</id_user>
              <firstname>first</firstname>
              <lastname>last</lastname>
              <company/>
              <email>mail@web.de</email>
              <timezone>Europe/Berlin</timezone>
              <time_signup>Wed, 11 May 2011 20:57:15 +0200</time_signup>
              <lang>1</lang>
              <avatar>http://producteev.com//static/images/default-avatar.jpg</avatar>
              <deleted>0</deleted>
              <default_dashboard>243972</default_dashboard>
              <sort_by>4</sort_by>
              <facebooks/>
              <colleagues/>
              <dashboard_status>1</dashboard_status>
            </user>
          </node>
        </accesslist>
      </dashboard>
    </node>"""
}
